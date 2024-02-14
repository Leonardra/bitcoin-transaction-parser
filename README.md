#Oze Backend Task
***
#GitHub Repository
https://github.com/Leonardra/bitcoin-transaction-parser
***

# Prerequisites
* Java 11
* Maven
* PostMan


##To build
```shell
mvn clean install
```

##To run
```shell
mvn spring-boot:run
```

To run a request, send a GET request to the following url

```shell
http://localhost:8080/bitcoin/transaction/parse?transactionHex={trransactionHexValue}
```




