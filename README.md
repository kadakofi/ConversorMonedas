# 🏦 Conversor de Monedas 💰

![image](https://github.com/user-attachments/assets/24cae8dc-8097-4570-9997-4d5344bd2a0d)

ConversorMonedas es una aplicación desarrollada en Java que permite convertir entre diferentes tipos de monedas utilizando tasas de cambio actualizadas.

## Características principales 🚀

- ✅ Conversión entre múltiples divisas (USD, EUR, GBP, JPY, MXN, CAD, BRL, ARS, COP, CHF, AUD, CNY, INR, KRW, RUB, ZAR, NZD, SGD, HKD, TRY, THB, MYR, SEK, NOK, DKK, PLN, HUF, CZK, ILS, PHP, IDR, PKR, AED, SAR, CLP, EGP, BDT, VND, KWD, QAR, OMR, LKR, BGN, HRK, RON, ISK, XAF, XOF, NGN, GHS, MAD, DZD, TND, UGX, KES, TZS, ETB, ZMW, BHD, JOD, IRR, LBP, NPR, MMK, KZT, GEL, UAH)
- ✅ Interfaz de usuario simple e intuitiva
- ✅ Consumo de API para tasas de cambio actualizadas
- ✅ Soporte para múltiples idiomas
- ✅ Reportes de conversiones recientes

Aquí algunas capturas de la aplicación en funcionamiento:

![image](https://github.com/user-attachments/assets/5d1bcf22-0b58-41bc-ae8d-e053c0d3bdb2)

## Instalación 🛠️

Sigue estos pasos para ejecutar el proyecto en tu máquina local:

1. Clona este repositorio:

   git clone https://github.com/tu-usuario/ConversorMonedas.git
   
2. Accede al directorio del proyecto:

  cd ConversorMonedas
  
3. Construye el proyecto usando Maven:

  mvn clean install

4. Ejecuta la aplicación:

  java -jar target/conversor-monedas.jar

Tecnologías utilizadas 🛠️
  Java 17 (Liberica JDK)
  Apache HttpClient para solicitudes HTTP
  Jackson para procesamiento de JSON
  IntelliJ IDEA como entorno de desarrollo
  Maven para la gestión de dependencias
  
Uso 📖
  Ingresa la cantidad y selecciona las monedas de origen y destino.
  Presiona "Convertir" y obtendrás el resultado en segundos.
  
API utilizada 🌍
Este proyecto utiliza la API de tasas de cambio de ExchangeRate-API para obtener tasas de conversión en tiempo real.
