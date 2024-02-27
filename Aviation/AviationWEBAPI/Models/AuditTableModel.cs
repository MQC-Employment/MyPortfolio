using AviationWEBAPI.Entities;
using Dapper;
using Dapper.Oracle;
using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace AviationWEBAPI.Models
{

    /// <summary>
    /// Holds all the methods for the AuditTable table.
    /// </summary>
    public class AuditTableModel
    {

        private readonly IConfiguration configuration;
        private readonly string? oracleDataConnection;

        public AuditTableModel(IConfiguration configurationP) { 
        
            configuration = configurationP;
            oracleDataConnection = configuration.GetConnectionString("OracleConnection");
        
        }   //End of constructor.

        /// <summary>
        /// Returns all the events in the aduti table.
        /// </summary>
        /// <returns>A list of AuditTableObj if there are event; null if empty.</returns>
        public async Task<List<AuditTableObj>?> getAllAuditEvents()
        {

            List<AuditTableObj> auditTableList = new List<AuditTableObj>();
            const string storeProcedureName = "AuditTablePackge.getAllAuditEvents";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();
            dynamicParameters.Add("auditEventsCursorP", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            await oracleConnection.OpenAsync();

            auditTableList = (await oracleConnection.QueryAsync<AuditTableObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure)).ToList();

            await oracleConnection.CloseAsync();

            if (auditTableList.Count > 0)
            {

                return auditTableList;

            } else { 
                
                return null; 
            
            } //End of else.  

        } //End of getAllAuditEvents.

        /// <summary>
        /// Gets the events of the AuditTable with basic pagination.
        /// </summary>
        /// <param name="pageNumberP">The page number. Min page number is 1.</param>
        /// <returns>A list with a limited number of AuditTableObj objects; null if no events.</returns>
        public async Task<List<AuditTableObj>?> getAuditEventsPerPage(ulong pageNumberP)
        {

            List<AuditTableObj> auditTableList = new List<AuditTableObj>();
            const string storeProcedureName = "AuditTablePackge.getAuditEventsPerPage";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();
            dynamicParameters.Add("pageNumberP", pageNumberP, OracleMappingType.Int64, ParameterDirection.Input);
            dynamicParameters.Add("auditEventsCursorP", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            await oracleConnection.OpenAsync();

            auditTableList = (await oracleConnection.QueryAsync<AuditTableObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure)).ToList();

            await oracleConnection.CloseAsync();

            if (auditTableList.Count > 0)
            {

                return auditTableList;

            }
            else
            {

                return null;

            } //End of else. 

        } //End of getAuditEventsPerPage.

        public async void registerAuditEvent(string eventMessageP, DateTime dateTimeOfEventP)
        {

            const string storedProcedure = "AuditTablePackge.insertAuditEvent";

            OracleConnection connection = new OracleConnection(oracleDataConnection); 
            OracleDynamicParameters oracleDynamicParameters = new OracleDynamicParameters();
            oracleDynamicParameters.Add("eventMessageP",eventMessageP,OracleMappingType.Varchar2, ParameterDirection.Input);
            oracleDynamicParameters.Add("dateOfEventP", dateTimeOfEventP,OracleMappingType.Date, ParameterDirection.Input);
     
            await connection.OpenAsync();

            await connection.ExecuteAsync(storedProcedure, oracleDynamicParameters, commandType: CommandType.StoredProcedure);

            await connection.CloseAsync();

        } //End of registerAuditEvent.

    } //end of class.

} //End of namespace. 