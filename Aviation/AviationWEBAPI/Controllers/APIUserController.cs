using AviationWEBAPI.Entities;
using AviationWEBAPI.Models;
using Microsoft.AspNetCore.Mvc;

namespace AviationWEBAPI.Controllers
{

    /// <summary>
    /// This controller deals with all the methods for the API users.
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class APIUserController : ControllerBase
    {

        private readonly IConfiguration configuration;
        private readonly APIUserModel APIUserModel;
        private readonly APIAutenticationModel APIAutenticationModel;
        private readonly AuditTableModel auditTableModel;

        public APIUserController(IConfiguration configurationP) { 
        
            configuration = configurationP;
            APIUserModel = new APIUserModel(configuration);
            APIAutenticationModel = new APIAutenticationModel(configuration);
            auditTableModel = new AuditTableModel(configuration);   

        } //End of constructor.

        /// <summary>
        /// Get mathods that obtains all the API users. 
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get:
        /// 
        ///     Get /APIUser
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": {
        ///         "userID": "string",
        ///         "userEmail": "string",
        ///         "userAPIKey": "string"
        ///       }
        ///     }
        /// 
        /// </remarks>
        /// <param name="apiUserEmailP">The email of the registered API user.</param>
        /// <param name="apiUserPassword">The password of the registered API user.</param>
        /// <param name="APITokenP">The API token of the registered API user.</param>
        /// <returns>An APIAnswerObj with its requested data.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK response.</response>
        [HttpGet]
        [Route("getAllAPIUsers")]
        [Produces("application/Json")]
        public async Task<APIAnswerObj<List<APIUserObj>?>> getAPIUsers(string apiUserEmailP, string apiUserPassword, string APITokenP)
        {

            try
            {

                uint[] allowedRoles = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) &&
                    await APIAutenticationModel.authenticateAPIUsage(apiUserEmailP, apiUserPassword, APITokenP, allowedRoles)){

                    List<APIUserObj>? apiUserList = await APIUserModel.getAPIUsers();

                    if (apiUserList != null)
                    {


                        return APIAnswerObj<List<APIUserObj>?>.constructAPIMessage(1, "Ok", apiUserList);

                    }
                    else
                    {

                        return APIAnswerObj<List<APIUserObj>?>.constructAPIMessage<List<APIUserObj>>(2, "List is empty.", null);

                    }

                }
                else
                {

                    return APIAnswerObj<List<APIUserObj>?>.constructAPIMessage<List<APIUserObj>>(-1, "Access denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<List<APIUserObj>?>.constructAPIMessage<List<APIUserObj>>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getAuditEvents.

        /// <summary>
        /// Get method that gets an specific regitered API user. 
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get:
        /// 
        ///     Get /APIUser
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": {
        ///         "userID": "string",
        ///         "userEmail": "string",
        ///         "userAPIKey": "string"
        ///       }
        ///     }
        /// 
        /// </remarks>
        /// <param name="userAPIIDP">The ID of the registered API user to look up.</param>
        /// <param name="apiUserPassword">The password of the registered API user.</param>
        /// <param name="apiUserEmailP">The email of the requester API user.</param>
        /// <param name="APITokenP">The API Token of the requester API user.</param>
        /// <returns>An APIAnswerObj.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>        
        [HttpGet]
        [Route("getAPIUser")]
        public async Task<APIAnswerObj<APIUserObj?>> getAPIUser(string userAPIIDP, string apiUserEmailP, string apiUserPassword, string APITokenP)
        {

            try
            {

                uint[] allowedRoles = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) &&
                    await APIAutenticationModel.authenticateAPIUsage(apiUserEmailP, apiUserPassword, APITokenP, allowedRoles))
                {

                    APIUserObj? useraPI = await APIUserModel.getAPIUser(userAPIIDP);

                    if (useraPI != null)
                    {


                        return APIAnswerObj<APIUserObj?>.constructAPIMessage(1, "Ok", useraPI);

                    }
                    else
                    {

                        return APIAnswerObj<APIUserObj?>.constructAPIMessage<APIUserObj>(2, "User not found.", null);

                    }

                }
                else
                {

                    return APIAnswerObj<APIUserObj?>.constructAPIMessage<APIUserObj>(-1, "Access denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<APIUserObj?>.constructAPIMessage<APIUserObj>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getAPIUser.

    } //End of class.

} //End of namespace.