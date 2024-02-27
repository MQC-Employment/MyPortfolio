using System.Text.Json.Serialization;

namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// A representation of the APIUser table.
    /// </summary>
    public class APIUserObj
    {

        private byte[] userIDbyteArrayInternal = new byte[16];

        /// <summary>
        /// This would be the user ID in the database in its raw value. Oracles uses raw(16) to store a GUID.
        /// This attribute does not leave the API at all.
        /// </summary>
        [JsonIgnore]
        public byte[] userIDbyteArray {

            get {
            
                return userIDbyteArrayInternal;
            
            }

            set { 
            
                userID = ByteAndHexaDecimalTools.convertByteArrayToHexadecimalStringValue(value);

                userIDbyteArrayInternal = value;
            
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

        private byte[] userAPIKeybyteArrayInternal = new byte[16];  
        /// <summary>
        /// This is the raw value of the user's API key stored in the data base. It offers the same analogy as 
        /// the userIDbyteArray and userID when it comes to conversation.
        /// </summary>
        [JsonIgnore]
        public byte[] userAPIKeybyteArray
        {

            get
            {

                return userAPIKeybyteArrayInternal;

            }

            set
            {

                userAPIKey = ByteAndHexaDecimalTools.convertByteArrayToHexadecimalStringValue(value);

                userAPIKeybyteArrayInternal = value;    

            }

        }

        /// <summary>
        /// The user's API key in hexadecimal string value.
        /// </summary>
        public string userAPIKey { get; private set; } = String.Empty;

    } //End of APIUserObj.

} //End of namespace.
