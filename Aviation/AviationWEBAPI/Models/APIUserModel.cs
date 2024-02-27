using AviationWEBAPI.Entities;
using Dapper;
using Dapper.Oracle;
using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace AviationWEBAPI.Models
{

    /// <summary>
    /// Holds all the methods for the APIUser table.
    /// </summary>
    public class APIUserModel
    {

        private readonly IConfiguration configuration;
        private readonly string? oracleDataConnection;

        public APIUserModel(IConfiguration configurationP) { 
        
            configuration = configurationP;
            oracleDataConnection = configuration.GetConnectionString("OracleConnection");
        
        }   //End of constructor.

        /// <summary>
        /// Gets all the API users in the database. 
        /// </summary>
        /// <returns>Returns an APIUserObj list if there are values, or null if it's empty.</returns>
        public async Task<List<APIUserObj>?> getAPIUsers()
        {

            List<APIUserObj> userAPIList = new List<APIUserObj>();
            const string storeProcedureName = "APIUserPackage.getAPIUsers";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            await oracleConnection.OpenAsync();

            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();
            dynamicParameters.Add("APIUsersCursor", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            userAPIList = (await oracleConnection.QueryAsync<APIUserObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure)).ToList();

            await oracleConnection.CloseAsync();
                       
            if (userAPIList.Count > 0)
            {

                return userAPIList;

            }
            else
            {

                return null;

            } //End of else.  

        } //End of getAPIUsers.

        /// <summary>
        /// Looks up an specific user with their hexadecimal string value.
        /// </summary>
        /// <param name="hexadecimalUserAPIIDP">The hexadecimal string value of the user ID to look up.</param>
        /// <returns>The specified user if found, or null if not found.</returns>
        public async Task<APIUserObj?> getAPIUser(string hexadecimalUserAPIIDP) { 
        
            APIUserObj? userAPIObj = new APIUserObj();
            byte[] bytes = ByteAndHexaDecimalTools.convertHexadecimalStringValueToByteArray(hexadecimalUserAPIIDP);
            const string storeProcedureName = "APIUserPackage.getAPIUser";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            await oracleConnection.OpenAsync();
          
            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();            
            dynamicParameters.Add("userAPIIDP", bytes, OracleMappingType.Raw, ParameterDirection.Input);
            dynamicParameters.Add("APIUserCursor", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            userAPIObj = (await oracleConnection.QueryFirstOrDefaultAsync<APIUserObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure));

            await oracleConnection.CloseAsync();

            if (userAPIObj != null)
            {

                return userAPIObj;

            } else { 
                
                return null; 
            
            } //End of else.  

        } //End of getAPIUser.

    } //end of class.

} //End of namespace. 