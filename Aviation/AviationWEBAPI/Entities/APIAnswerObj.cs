namespace AviationWEBAPI.Entities
{

    /// <summary>
    /// A class that allows to send formalized API responses with codes, messages, and the data (if requested).
    /// 
    /// This class uses the generic type of C#, so any kind of data can be sent. Along that, such generic type
    /// avoids multiple unnecessary instantiations for each data type desired. 
    /// 
    /// </summary>
    /// <typeparam name="T">The generic type that is desired to be used.
    /// It can be from basic data types to complex objects.
    /// </typeparam>
    public class APIAnswerObj<T>
    {

        /// <summary>
        /// Represents the an answer code ID. In example: "1" means OK; "2" means no data found; and so on! 
        /// </summary>
        public long answerID { get; private set; } = 0;

        /// <summary>
        /// A messages that describes the state of the API answer. In example: "User not found."
        /// </summary>
        public string message { get; private set; } = string.Empty; 

        /// <summary>
        /// The generyc type of data that is desired to be used. It can be from basic data types to complex objects.
        /// </summary>
        public T? value { get; private set; } = default(T);

        /// <summary>
        /// Builds the API answer object that will be sent to the user. This constructor is private.
        /// To get an APIAnswerObj, use the "constructAPIMessage" methdod below.
        /// </summary>
        /// <param name="answerIDP">The ID of the API answer.</param>
        /// <param name="messageP">The message of the API answer.</param>
        /// <param name="valueP">The data desired to be sent.</param>
        private APIAnswerObj(long answerIDP, string messageP, T? valueP)
        {

            answerID = answerIDP;
            message = messageP; 
            value = valueP; 

        } //End of constructor. 

        /// <summary>
        /// This methods retuns an already constructed APIAnswerObj. It simplifies the process by simply 
        /// requesting the parameters and returning the built APIAnswerObj back. 
        /// 
        /// Since all the controllers return an APIAnswerObj to the user, this method was
        /// created to simplify such process. With this, it's not necessary to have many lines 
        /// of repetitive code whenever an APIAnswerObj is required.
        /// 
        /// Simply call to this static method; fill out the parameters required and send it. 
        /// 
        /// </summary>
        /// <typeparam name="T">The data desired to be sent.</typeparam>
        /// <param name="answerIDP">The ID of the API answer.</param>
        /// <param name="messageP">The message of the API answer.</param>
        /// <param name="valueP">The data desired to be sent.</param>
        /// <returns>A built APIAnswerObj.</returns>
        public static APIAnswerObj<T?> constructAPIMessage<T>(long answerIDP, string messageP, T? valueP)
        {

            APIAnswerObj<T?> aPIAnswerObj = new APIAnswerObj<T?>(answerIDP, messageP, valueP);  

            return aPIAnswerObj;

        } //End of constructAPIMessage.

    } //End of class.

} //End of namespace.