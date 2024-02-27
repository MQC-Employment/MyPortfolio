using AviationWEBAPI.Entities;
using AviationWEBAPI.Models;
using Microsoft.AspNetCore.Mvc;
using System;

namespace AviationWEBAPI.Controllers
{

    /// <summary>
    /// This controller deals with all the methods for the application users.
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class ApplicationUserController : ControllerBase
    {

        private readonly IConfiguration configuration;
        private readonly ApplicationUserModel applicationUserModel;
        private readonly APIAutenticationModel APIAutenticationModel;
        private readonly AuditTableModel auditTableModel;

        public ApplicationUserController(IConfiguration configurationP) { 
        
            configuration = configurationP;
            applicationUserModel = new ApplicationUserModel(configuration);
            APIAutenticationModel = new APIAutenticationModel(configuration);
            auditTableModel = new AuditTableModel(configuration);   

        } //End of constructor.

        /// <summary>
        /// Get mathods that obtains all the application users. 
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get:
        /// 
        ///     Get /ApplicationUser
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": {
        ///         "userID": "string",
        ///         "userEmail": "string",
        ///         "firstName": "string",
        ///         "lastName": "string",
        ///         "phoneNumber": "string",
        ///         "address": "string"
        ///       }
        ///     }
        /// 
        /// </remarks>
        /// <param name="apiUserEmailP">The email of the registered API user.</param>
        /// <param name="APITokenP">The API token of the registered API user.</param>
        /// <returns>An APIAnswerObj with its requested data.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>
        [HttpGet]
        [Route("getAllApplicationUsers")]
        [Produces("application/Json")]
        public async Task<APIAnswerObj<List<ApplicationUserObj>?>> getApplicationUsers(string apiUserEmailP, string APITokenP)
        {

            try
            {

                uint[] allowedRoles = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) &&
                    await APIAutenticationModel.authenticateAPIUsage(apiUserEmailP, APITokenP, allowedRoles)){

                    List<ApplicationUserObj>? applicationUserList = await applicationUserModel.getApplicationUsers();

                    if (applicationUserList != null)
                    {


                        return APIAnswerObj<List<ApplicationUserObj>?>.constructAPIMessage(1, "Ok", applicationUserList);

                    }
                    else
                    {

                        return APIAnswerObj<List<ApplicationUserObj>?>.constructAPIMessage<List<ApplicationUserObj>>(2, "List is empty.", null);

                    }

                }
                else
                {

                    return APIAnswerObj<List<ApplicationUserObj>?>.constructAPIMessage<List<ApplicationUserObj>>(-1, "Access denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<List<ApplicationUserObj>?>.constructAPIMessage<List<ApplicationUserObj>>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getApplicationUsers.

        /// <summary>
        /// Get method that gets an specific regitered application user. 
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get:
        /// 
        ///     Get /ApplicationUser
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": {
        ///         "userID": "string",
        ///         "userEmail": "string",
        ///         "firstName": "string",
        ///         "lastName": "string",
        ///         "phoneNumber": "string",
        ///         "address": "string"
        ///       }
        ///     }
        /// 
        /// </remarks>
        /// <param name="userAPIIDP">The ID of the registered application user to look up.</param>
        /// <param name="apiUserEmailP">The email of the requester API user.</param>
        /// <param name="APITokenP">The API Token of the requester API user.</param>
        /// <returns>An APIAnswerObj.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>        
        [HttpGet]
        [Route("getApplicationUser")]
        public async Task<APIAnswerObj<ApplicationUserObj?>> getApplicationUser(string userAPIIDP, string apiUserEmailP, string APITokenP)
        {

            try
            {

                uint[] allowedRoles = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) &&
                    await APIAutenticationModel.authenticateAPIUsage(apiUserEmailP, APITokenP, allowedRoles))
                {

                    ApplicationUserObj? useraPI = await applicationUserModel.getApplicationUserByID(userAPIIDP);

                    if (useraPI != null)
                    {


                        return APIAnswerObj<ApplicationUserObj?>.constructAPIMessage(1, "Ok", useraPI);

                    }
                    else
                    {

                        return APIAnswerObj<ApplicationUserObj?>.constructAPIMessage<ApplicationUserObj>(2, "User not found.", null);

                    }

                }
                else
                {

                    return APIAnswerObj<APIUserObj?>.constructAPIMessage<ApplicationUserObj>(-1, "Access denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<APIUserObj?>.constructAPIMessage<ApplicationUserObj>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getAPIUser.

        /// <summary>
        /// Registers a new user in the database.
        /// </summary>
        /// <remarks>
        /// Post example:
        /// 
        ///     Post /ApplicationUser 
        ///     {
        ///       "userEmail": "testemail@domain.com",
        ///       "userPassword": "23423dSDFS5",
        ///       "firstName": "Mario",
        ///       "lastName": "Bros",
        ///       "phoneNumber": "8888-8888",
        ///       "address": "Mushroom Kingdom"
        ///     }
        /// 
        /// </remarks>
        /// <param name="apiUserEmailP">The email of the API user.</param>
        /// <param name="APITokenP">The token of the API user.</param>
        /// <param name="newUserP">The new user in JSON string.</param>
        /// <returns>An APIAnswerObj with the new application user.</returns>
        /// <response code="1">New user successfully registered.</response>
        /// <response code="2">Unable to register new user.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>  
        [HttpPost]
        [Route("registerNewUser")]
        public async Task<APIAnswerObj<ApplicationUserObj?>> registerNewapplicationUser(string apiUserEmailP, string APITokenP, ApplicationUserObj newUserP)
        {

            try
            {

                uint[] allowedRoles = [1];

                if(ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) &&
                    await APIAutenticationModel.authenticateAPIUsage(apiUserEmailP, APITokenP, allowedRoles)){

                    ApplicationUserObj? newUser = await applicationUserModel.registerNewApplicationUser(newUserP);

                    if(newUser != null)
                    {

                        return APIAnswerObj<ApplicationUserObj>.constructAPIMessage<ApplicationUserObj>(1, "New user registered", newUser);

                    }
                    else
                    {

                        return APIAnswerObj<ApplicationUserObj>.constructAPIMessage<ApplicationUserObj>(-1, "Unable to register new user.", newUser);


                    }

                }
                else
                {

                    return APIAnswerObj<ApplicationUserObj>.constructAPIMessage<ApplicationUserObj>(-1, "Access denied.", null);


                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<ApplicationUserObj>.constructAPIMessage<ApplicationUserObj>(-1, "Error: " + exception.Message, null);
                
            }

        } //End of registerNewapplicationUser.

    } //End of class.

} //End of namespace.