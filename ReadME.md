# [Kafka Weblogic Producer/Consumer]()

### Pre-Requisite
* Java8
* Kafka + ZooKeepr
* Weblogic >= 12

### Setup Locally
* Start Kafka
* Start Weblogic

Once confirmed to have above mentioned both services are running, execute below command
 ```bash
 git clone git@github.com:singh-saurav/kafka-demo.git
 cd kafka-demo
 mvn clean package
 ```
In target war file has been created. Now Deploy this war file under Weblogic deployment.

You should be all good. Try to pay attention to folder [webapp](src/main/webapp). This is the part which enables war file compatible with Weblogic.

### Testing 
Producer has api to send message number of message
[http://$host:$port/kafka/message/$count]()

Note: Replace all **$** variables with appropriate value.

**Cheers!**