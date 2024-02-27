using System.Text.Json.Serialization;

namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// A representation of the ApplicationUserObj table.
    /// </summary>
    public class ApplicationUserObj
    {

        private byte[] userIDByteArrayInternalValue = new byte[16];
        /// <summary>
        /// This would be the user ID in the database in its raw value. Oracles uses raw(16) to store a GUID.
        /// This attribute does not leave the API at all.
        /// </summary>
        [JsonIgnore]
        public byte[] userIDByteArray        
        { 
            get 
            { 

                return userIDByteArrayInternalValue; 
            
            }
            
            set 
            {

                this.userID = ByteAndHexaDecimalTools.convertByteArrayToHexadecimalStringValue(value);

                userIDByteArrayInternalValue = value; 
            
            }

        }

        /// <summary>
        /// The ID of the user in hexadecimal string value. Since JSON, eventually, doesn't support raw/byte values, 
        /// we need to convert the raw ID into a hexadeicmal value string, this one. 
        /// This is the value that will be sent to the user. The user MUST sent the value back also as
        /// a hexadecimal string, where we will convert it into its proper byte array / raw value, 
        /// and send it to the data base. 
        /// 
        /// In other words:
        /// If we receive this attribute, we convert it into its raw value (userIDbyteArray) 
        /// and sent it to the database; if we send this attribute, 
        /// we need to convert its raw value (userIDbyteArray) first into this hexadecimal string, 
        /// and then send it. 
        /// 
        /// </summary>
        public string userID { get; private set; } = String.Empty;

        /// <summary>
        /// Represents the user's email.
        /// </summary>
        public string userEmail { get; set; } = String.Empty;
        /// <summary>
        /// Allows to store new users' password when they desire to renew it. Passwords DOES NOT leave the database, ever. 
        /// </summary>
        public string userPassword { private get; set; } = String.Empty;

        /// <summary>
        /// The first name of the user.
        /// </summary>
        public string firstName { get; set; } = String.Empty;
        /// <summary>
        /// The last name of the user.
        /// </summary>
        public string lastName { get; set; } = String.Empty;
        /// <summary>
        /// The phone number of the user.
        /// </summary>
        public string phoneNumber { get; set; } = String.Empty;
        /// <summary>
        /// The address of the user.
        /// </summary>
        public string address { get; set; } = String.Empty;

        /// <summary>
        /// Returns the user's password for mapping ONLY.
        /// </summary>
        /// <returns></returns>
        public string getUserPassword()
        {

            return userPassword;

        }

    } //End of ApplicationUerObj.

} //End of namespace.
