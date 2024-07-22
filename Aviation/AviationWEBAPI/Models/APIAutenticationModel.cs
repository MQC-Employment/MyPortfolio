using AviationWEBAPI.Entities;
using Dapper;
using Dapper.Oracle;
using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace AviationWEBAPI.Models
{

    /// <summary>
    /// This model possesses all the autentication methods and fuctions required for external uses to use the API.
    /// </summary>
    public class APIAutenticationModel
    {

        private readonly IConfiguration configuration;
        private readonly string? oracleDataConnection;
        private readonly APIUserModel APIuserModel;
        private readonly APIUserRoleModel APIUserRoleModel;

        public APIAutenticationModel(IConfiguration configuration)
        {
            this.configuration = configuration;
            this.oracleDataConnection = configuration.GetConnectionString("OracleConnection");
            this.APIuserModel = new APIUserModel(configuration);
            this.APIUserRoleModel = new APIUserRoleModel(configuration);

        }

        /// <summary>
        /// This methods verifies whether an API user is allowed to consume a desired API method in the controller. 
        /// - Use thi method to implement security to the API calls. It verifies whether the user is registered
        /// in the APIUser table, got a valid API token, and also whether the API user got the role/s 
        /// needed to use the desired method. - At least one role must be met.
        /// </summary>
        /// <param name="apiUserEmailP">The email of the API user to authenticate.</param>
        /// <param name="userAPIKeyP">The API token of the API user to authenticate.</param>
        /// <param name="rolesAllowedP">The role identifiers that are required to access the method. Please, refer to 
        /// the roleIdenfier in the APIUserRole list to reference these roles. - At least one role must be met.</param>
        /// <returns>True if user is authenticated and allowed to consume the service, false if not.</returns>
        public async Task<bool> authenticateAPIUsage(string apiUserEmailP,string apiUserPassword,string userAPIKeyP, uint[] rolesAllowedP)
        {

            List<uint> listaOfAllowedRoles = rolesAllowedP.ToList();
            APIUserObj? userObj = await apiUsageAuthentication(apiUserEmailP,apiUserPassword,userAPIKeyP);
            
            if (userObj != null)
            {

                List<APIUserRoleObj>? userRoleList = await APIUserRoleModel.getRolesFromAPIUser(userObj.userID);                

                if (userRoleList!=null)
                {

                    List<uint> listOfRolesIdentifier = userRoleList.Select(x => x.roleIdentifier).ToList();

                    bool hasAllowedRole = listOfRolesIdentifier.Select(x => x)
                          .Intersect(listaOfAllowedRoles)
                          .Any();

                    return hasAllowedRole;

                }
                else
                {

                    return false;

                }
            }
            else
            {

                return false; 

            }

        } //End of authenticateAPIUser.

        /// <summary>
        /// This method verifies whether the user is a registered API user with a valid API key who is allowed to use
        /// this API.
        /// </summary>
        /// <param name="apiUserEmailP">The email of the registered AIP user.</param>
        /// <param name="userAPIKeyP">The hexadecimal API Key of the registered API user.</param>
        /// <returns>The API user if authenticated; null if not.</returns>
        private async Task<APIUserObj?> apiUsageAuthentication(string apiUserEmailP, string apiUserPassword, string userAPIKeyP)
        {

            const string storedProcedureName = "APIUserPackage.apiUsageAuthentication";

            APIUserObj? APIUserObj = new APIUserObj();
            byte[] userAPIKeyRaw = ByteAndHexaDecimalTools.convertHexadecimalStringValueToByteArray(userAPIKeyP);

            OracleConnection connection = new OracleConnection(oracleDataConnection);

            await connection.OpenAsync();

            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();
            dynamicParameters.Add("apiUserEmailP", apiUserEmailP, OracleMappingType.Varchar2, ParameterDirection.Input);
            dynamicParameters.Add("apiUserPasswordP", apiUserPassword, OracleMappingType.Varchar2, ParameterDirection.Input);
            dynamicParameters.Add("userAPIKeyP", userAPIKeyRaw, OracleMappingType.Raw, ParameterDirection.Input);
            dynamicParameters.Add("apiUserCursor", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            APIUserObj = await connection.QueryFirstOrDefaultAsync<APIUserObj>(storedProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure);

            await connection.CloseAsync();

            if (APIUserObj != null)
            {

                return APIUserObj;

            }
            else
            {

                return null;

            }

        } //End of apiUserAuthentication.

    } //End of class.

} //End of namespace. 
