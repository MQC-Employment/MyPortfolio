namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// A class representation of the APIUserRole table in the database.
    /// </summary>
    public class APIUserRoleObj
    {

        /// <summary>
        /// The unique identifier of the role.
        /// </summary>
        public uint roleIdentifier { get; set; } = 0;

        /// <summary>
        /// The name of the role. 
        /// </summary>
        public string roleName { get; set; } = String.Empty;

    } //End of class.

} //End of namespace.
