namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// This static class offers utilies to deal with: the GUID raw values worked with Oracle databases;
    /// converting hexadecimal string to byte arrays which are the raw values for the database;
    /// convert such raw values (byte arrays) into a hexadecimal string; checking whether a hexadecimal string
    /// is a valid one.
    /// </summary>
    public static class ByteAndHexaDecimalTools
    {

        /// <summary>
        /// Take an array of bytes and converts them into a hexadecimal string.
        /// </summary>
        /// <param name="byteArrayP">The byte array to convert into a hexadecimal string.</param>
        /// <returns>A hexadecimal string.</returns>
        public static string convertByteArrayToHexadecimalStringValue(byte[] byteArrayP)
        {

            return BitConverter.ToString(byteArrayP).Replace("-", "");

        } //End of convertByteArrayToHexadecimalStringValue.

        /// <summary>
        /// Takes a hexadecimal string and converts it into an array of bytes.
        /// </summary>
        /// <param name="hexadecimalStringValueP">The hexadecimal sring to convert into an array of bytes.</param>
        /// <returns>An array of bytes.</returns>
        public static byte[] convertHexadecimalStringValueToByteArray(string hexadecimalStringValueP)
        {

            return Convert.FromHexString(hexadecimalStringValueP);

        } //End of convertHexadecimalStringValueToByteArray.

        /// <summary>
        /// Checks whether a hexadecimal string is a valid one.
        /// </summary>
        /// <param name="hexadeciamlStringToCheckP">The hexadecimal string to check.</param>
        /// <returns>True if valid; flase if not.</returns>
        public static bool checkHexadecimalValidString(string hexadeciamlStringToCheckP)
        {

            return (hexadeciamlStringToCheckP.Length % 2) == 0;

        } //End of checkHexadecimalValidString.

    } //End of class.

} //End of namespace.
