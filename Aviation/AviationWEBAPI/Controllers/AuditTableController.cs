using AviationWEBAPI.Entities;
using AviationWEBAPI.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace AviationWEBAPI.Controllers
{

    /// <summary>
    /// This controller handles all the methods of the AuditTable. 
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class AuditTableController : ControllerBase
    {

        private readonly IConfiguration configuration;
        private readonly AuditTableModel auditTableModel;
        private readonly APIAutenticationModel autenticationModel;

        public AuditTableController(IConfiguration configurationP) {

            configuration = configurationP;
            auditTableModel = new AuditTableModel(configuration);
            autenticationModel = new APIAutenticationModel(configuration);

        } //End of constructor.

        /// <summary>
        /// Get method that gets all the audit events of the AuditTAble.
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get: 
        /// 
        ///     Get /AuditTable
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": [
        ///         {
        ///           "internalEventID": 0,
        ///           "dateOfEvent": "2024-02-15T06:56:02.698Z",
        ///           "eventMessage": "string"
        ///         }
        ///       ]
        ///     }
        /// 
        /// </remarks>
        /// <param name="apiUserEmailP">The email of the registered API user.</param>
        /// <param name="APITokenP">The API token of the registered API user.</param>
        /// <returns>An APIAnswerObj with its data.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>
        [HttpGet]
        [Route("getAllAuditEvents")]
        [Produces("application/json")]
        public async Task<APIAnswerObj<List<AuditTableObj>?>> getAuditEvents(string apiUserEmailP, string APITokenP)
        {

            try
            {

                uint[] rolesAllowedForThisMethod = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP)
                    && await autenticationModel.authenticateAPIUsage(apiUserEmailP, APITokenP, rolesAllowedForThisMethod))
                {

                    List<AuditTableObj>? auditEventList = await auditTableModel.getAllAuditEvents();

                    if (auditEventList != null)
                    {


                        return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage(1, "Ok", auditEventList);

                    }
                    else
                    {

                        return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(2, "List is empty.", null);

                    }

                } else
                {

                    return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(-1, "Request denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getAuditEvents.


        /// <summary>
        /// Get method that gets all the audit events of the AuditTAble per page.
        /// </summary>
        /// <remarks>
        /// 
        /// Sample Get: 
        /// 
        ///     Get /AuditTable
        ///     {
        ///       "answerID": 0,
        ///       "message": "string",
        ///       "value": [
        ///         {
        ///           "internalEventID": 0,
        ///           "dateOfEvent": "2024-02-15T06:56:02.698Z",
        ///           "eventMessage": "string"
        ///         }
        ///       ]
        ///     }
        /// 
        /// </remarks>
        /// <param name="apiUserEmailP">The email of the registered API user.</param>
        /// <param name="APITokenP">The API token of the registered API user.</param>
        /// <param name="pageNumberP">Page number to consult. Min page number is 1.</param>
        /// <returns>And APIAnswerObj with its requested data.</returns>
        /// <response code="1">Request was successful and data was obtained.</response>
        /// <response code="2">Request was successful, yet no data obtained.</response>
        /// <response code="-1">An error or exception has occurred.</response>
        /// <response code="200">Generic OK respose.</response>
        [HttpGet]
        [Route("getAllAuditEventsPerPage")]
        [Produces("application/json")]
        public async Task<APIAnswerObj<List<AuditTableObj>?>> getAuditEventsPerPage(string apiUserEmailP, string APITokenP, ulong pageNumberP)
        {

            try
            {
                uint[] rolesAllowedForThisMethod = [1];

                if (ByteAndHexaDecimalTools.checkHexadecimalValidString(APITokenP) && pageNumberP>=1
                    && await autenticationModel.authenticateAPIUsage(apiUserEmailP, APITokenP, rolesAllowedForThisMethod))
                {

                    List<AuditTableObj>? auditEventList = await auditTableModel.getAuditEventsPerPage(pageNumberP);

                    if (auditEventList != null)
                    {


                        return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage(1, "Ok", auditEventList);

                    }
                    else
                    {

                        return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(2, "List is empty.", null);

                    }

                }
                else
                {

                    return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(-1, "Access denied.", null);

                }

            }
            catch (Exception exception)
            {

                auditTableModel.registerAuditEvent("Exception:" + exception.Message, DateTime.Now);

                return APIAnswerObj<List<AuditTableObj>?>.constructAPIMessage<List<AuditTableObj>>(-1, "Error: " + exception.Message, null);

            } //End of catch.

        } //End of getAuditEventsPerPage.

    } //End of class.

} //End of namespace.