# Kafka

Utility classes for producing and consuming Kafka messages. The project uses Spring Kafka libraries to produce messages. Two types of events are created, an AssetEvent and a 
LightningEvent. These will be processed by Flink real-time analytical engine to determin if an alert needs to be raised based on specific rules that determine if a lightning
strike jeopardises a constrained asset. The goal is to view these alerts in Superset and also see the lightning strikes as they happen (Simulated of course :-))
