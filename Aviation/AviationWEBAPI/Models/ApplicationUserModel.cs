using AviationWEBAPI.Entities;
using Dapper;
using Dapper.Oracle;
using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace AviationWEBAPI.Models
{

    /// <summary>
    /// Holds all the methods for the ApplicationUser table.
    /// </summary>
    public class ApplicationUserModel
    {

        private readonly IConfiguration configuration;
        private readonly string? oracleDataConnection;

        public ApplicationUserModel(IConfiguration configurationP) { 
        
            configuration = configurationP;
            oracleDataConnection = configuration.GetConnectionString("OracleConnection");
        
        }   //End of constructor.

        /// <summary>
        /// Gets all the application users in the database. 
        /// </summary>
        /// <returns>Returns an application user list if there are values, or null if it's empty.</returns>
        public async Task<List<ApplicationUserObj>?> getApplicationUsers()
        {

            List<ApplicationUserObj> applicationUserList = new List<ApplicationUserObj>();
            const string storeProcedureName = "ApplicationUserPackage.getAllApplicationUsers";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();
            dynamicParameters.Add("applicationUserCursorP", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            await oracleConnection.OpenAsync();

            applicationUserList = (await oracleConnection.QueryAsync<ApplicationUserObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure)).ToList();

            await oracleConnection.CloseAsync();
                       
            if (applicationUserList.Count > 0)
            {

                return applicationUserList;

            }
            else
            {

                return null;

            } //End of else.  

        } //End of getApplicationUsers.

        /// <summary>
        /// Looks up an specific user with their hexadecimal string value.
        /// </summary>
        /// <param name="hexadecimalUserAPIIDP">The hexadecimal string value of the user ID to look up.</param>
        /// <returns>The specified user if found, or null if not found.</returns>
        public async Task<ApplicationUserObj?> getApplicationUserByID(string hexadecimalUserAPIIDP) {

            ApplicationUserObj? applicationUser = new ApplicationUserObj();
            byte[] bytes = ByteAndHexaDecimalTools.convertHexadecimalStringValueToByteArray(hexadecimalUserAPIIDP);
            const string storeProcedureName = "ApplicationUserPackage.getApplicationUserByID";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);
          
            OracleDynamicParameters dynamicParameters = new OracleDynamicParameters();            
            dynamicParameters.Add("applicationUserIDP", bytes, OracleMappingType.Raw, ParameterDirection.Input);
            dynamicParameters.Add("applicationUserCursorP", null, OracleMappingType.RefCursor, ParameterDirection.Output);

            await oracleConnection.OpenAsync();

            applicationUser = (await oracleConnection.QueryFirstOrDefaultAsync<ApplicationUserObj>(storeProcedureName, dynamicParameters, commandType: CommandType.StoredProcedure));

            await oracleConnection.CloseAsync();

            if (applicationUser != null)
            {

                return applicationUser;

            } else { 
                
                return null; 
            
            } //End of else.  

        } //End of getApplicationUserByID.

        /// <summary>
        /// Registers a new application user.
        /// </summary>
        /// <param name="newApplicationUserP">An ApplicationUserObj</param>
        /// <returns>The newly registered user, or null if registration was not possible.</returns>
        public async Task<ApplicationUserObj?> registerNewApplicationUser(ApplicationUserObj newApplicationUserP)
        {

            string storedProcedureName = "ApplicationUserPackage.registerNewApplicationUser";

            OracleConnection oracleConnection = new OracleConnection(oracleDataConnection);

            OracleDynamicParameters oracleDynamicParameters = new OracleDynamicParameters();    
            oracleDynamicParameters.Add("userEmailP",newApplicationUserP.userEmail,OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("userPasswordP", newApplicationUserP.getUserPassword(),OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("firstNameP", newApplicationUserP.firstName,OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("lastNameP", newApplicationUserP.lastName,OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("phoneNumberP", newApplicationUserP.phoneNumber,OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("addressP", newApplicationUserP.address,OracleMappingType.Varchar2,ParameterDirection.Input);
            oracleDynamicParameters.Add("userRegisteredIDP", newApplicationUserP.userID,OracleMappingType.Raw,ParameterDirection.Output);
            
            await oracleConnection.OpenAsync();   

            await oracleConnection.ExecuteAsync(storedProcedureName, oracleDynamicParameters,commandType:CommandType.StoredProcedure);

            await oracleConnection.CloseAsync();

            byte[] applicationUserID = oracleDynamicParameters.Get<byte[]>("userRegisteredIDP");

            if (applicationUserID != null)
            {

                string hexadeceimalUserID = ByteAndHexaDecimalTools.convertByteArrayToHexadecimalStringValue(applicationUserID);

                ApplicationUserObj? applicationUserObj = await getApplicationUserByID(hexadeceimalUserID);

                return applicationUserObj;  

            }
            else
            {

                return null;

            }

        } //End of registerNewApplicationUser.

    } //End of class.

} //End of namespace. 