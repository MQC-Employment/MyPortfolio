using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// A representation of the AuditTable table in the database. 
    /// </summary>
    public class AuditTableObj
    {

        /// <summary>
        /// The ID of the event.
        /// </summary>
        public ulong internalEventID { get; set; } = 0;

        /// <summary>
        /// When the even occurred. 
        /// </summary>
        public DateTime dateOfEvent { get; set; } = DateTime.MinValue;

        /// <summary>
        /// A description of the event.
        /// </summary>
        public string eventMessage { get; set;} = string.Empty; 

    } //Endo of Class.

} //End of namespace.
