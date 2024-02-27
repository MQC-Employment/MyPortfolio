#include <iostream>

using namespace std;

double convertirDeFahrenheitACelsiusByCopy(double gradosFahrenheitP);
double convertirDeFahrenheitACelsiusThroughReference(double &gradosFahrenheitP);
double convertirDeFahrenheitACelsiusByRValue(double &&gradosFahrenheitP);

int main(){

    double gradosFahrenheit{0.0};
    cout.precision(4);

    cout << "Enter the desired Fahrenheit temperature to convert to Celsius: ";
    cin >> gradosFahrenheit;

    cout << "The Fahrenheit temperature " << gradosFahrenheit << "°F is " << convertirDeFahrenheitACelsiusThroughReference(gradosFahrenheit) << "°C." << endl;

    return 0;

} //Fin del main.

double convertirDeFahrenheitACelsius(double gradosFahrenheitP){

    return (gradosFahrenheitP-32.0)*(5.0/9.0);

} //End of convertirDeFahrenheitACelsius.

double convertirDeFahrenheitACelsiusThroughReference(double &gradosFahrenheitP){

    return (gradosFahrenheitP-32.0)*(5.0/9.0);

} //End of convertirDeFahrenheitACelsiusThroughReference.

double convertirDeFahrenheitACelsiusByRValue(double &&gradosFahrenheitP){

    return (gradosFahrenheitP-32.0)*(5.0/9.0); 

} //End of convertirDeFahrenheitACelsiusByRValue.