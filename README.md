# Cyrpto Currencsy APP

The aim of the project is to get current data (currency and price information) of cryptocurrencies from an API and present this data to the user as a dynamic list (RecyclerView). The project involves getting data from an API with Retrofit, modeling this data (data class) and listing it using RecyclerView. The user can click on the cryptocurrencies in the list and perform certain interactions (for example, receiving notifications with a Toast message).

This project can be considered as a basic cryptocurrency tracking application and includes topics such as getting data with the API, listing it and managing user interactions.

## Features This application provides a platform where users can instantly view the prices of cryptocurrencies. Users can benefit from the following features through the application: - Cryptocurrency List: When the application is opened, you can see the names of different cryptocurrencies and their current prices.

- Interaction on the List: When you click on any item in the cryptocurrency list, the name of the cryptocurrency you have selected appears on the screen as a short message.

- Colored List: Each cryptocurrency in the list is shown with a different background color, so that the data can be distinguished more easily.

## Technologies Used **Retrofit:** Usage Purpose: Used to manage HTTP requests and retrieve data from the API. In this project, requests are sent to the cryptocurrency API with Retrofit and JSON data is retrieved.

**RxJava:** Usage Purpose: Used to manage asynchronous data flows. Data returned from the API call is processed asynchronously and UI updates are made.

**Gson:** Usage Purpose: Used to convert JSON data to Kotlin data classes. JSON data received with Retrofit is automatically converted to the CyriptoModel data class.

**RecyclerView:** Usage Purpose: Used to dynamically display data in a list. In this project, cryptocurrency information is listed with RecyclerView.

**LayoutInflater:** Usage Purpose: Used to convert XML layout files to View objects. In this project, cyripto_row.xml file is inflated as View to create item views.

**Color:** Purpose: Used to dynamically change the background color. Different colors are assigned to different cryptocurrency items.

**CompositeDisposable (RxJava):** Purpose: Used to manage RxJava transactions and cancel them when necessary. Unused resources are released when API requests are completed or errors occur.

**Data Class (Kotlin):** Purpose: Used to define the data model. CyriptoModel is the data class that represents cryptocurrency data (currency and price).

## Screenshots |||||
|--------------------|- ... | ![Screen 1](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/CyrptoCurrencyAPP/Ss1.png?raw=true) | ![Screen 2](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/CyrptoCurrencyAPP/Ss2.png?raw=true)
