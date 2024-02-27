using AviationWEBAPI.Entities;
using Dapper;
using Dapper.Oracle;
using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace AviationWEBAPI.Models
{

    /// <summary>
    /// This class contains all the methods related to the roles of the API users.
    /// </summary>
    public class APIUserRoleModel
    {

        private readonly IConfiguration configuration;
        private readonly string? oracleDataConnection;

        public APIUserRoleModel(IConfiguration configurationP)
        {

            this.configuration = configurationP;
            this.oracleDataConnection = configurationP.GetConnectionString("OracleConnection");

        }
        
        /// <summary>
        /// Gets all the roles from an specific API user. 
        /// </summary>
        /// <param name="userAPIIDP">The ID of the API user.</param>
        /// <returns>A list with all the respected roles of the specific user; null if no roles of the soecific user were found.</returns>
        public async Task<List<APIUserRoleObj>?> getRolesFromAPIUser(string userAPIIDP)
        {

            List<APIUserRoleObj>? userAPIRoles = new List<APIUserRoleObj>();

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);
            const string storedProcedureName = "APIUserRolePackage.getRolesFromAPIUser";

            OracleDynamicParameters oracleDynamicParameters = new OracleDynamicParameters();
            byte[] userAPIIDByteArray = ByteAndHexaDecimalTools.convertHexadecimalStringValueToByteArray(userAPIIDP);
            oracleDynamicParameters.Add("userAPIIDP", userAPIIDByteArray, OracleMappingType.Raw, direction: ParameterDirection.Input);
            oracleDynamicParameters.Add("APIUserRoleCursor", null, OracleMappingType.RefCursor, direction: ParameterDirection.Output);

            userAPIRoles = (await oracleConnection.QueryAsync<APIUserRoleObj>(storedProcedureName, oracleDynamicParameters, commandType: CommandType.StoredProcedure)).ToList();

            await oracleConnection.CloseAsync();

            if (userAPIRoles.Count() > 0 )
            {

                return userAPIRoles;

            }
            else
            {

                return null;

            }

        } //End of getRolesFromAPIUser.

    } //End of class.

} //End of namespace. 
