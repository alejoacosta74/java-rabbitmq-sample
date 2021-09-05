# RabbitMQ JAVA sample project

## About
This project implements a sender (aka `producer`) and a receiver (aka `consumer`), that exchange messages via a RabbitMQ server running on a docker container

## Dependencies
Insert the following in `build.gradle`:
```
dependencies {
implementation 'com.rabbitmq:amqp-client:5.13.1'
}
```

## Docker
Start RabbitMQ in a docker container with the following command:
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-managemen
```
## RabbitMQ CLI commands
Log in to `RabbitMQ` container to run the following commands:
```
docker exec -it rabbitmq bash
```
List channels
```shell
root@04491ade55ac:/# rabbitmqctl list_channels
Listing channels ...
pid     user    consumer_count  messages_unacknowledged
<rabbit@04491ade55ac.1630720420.29948.1>        guest   1       2
```
List bindings
```shell
root@04491ade55ac:/# rabbitmqctl list_bindings
Listing bindings for vhost /...
source_name     source_kind     destination_name        destination_kind        routing_key     arguments
exchange        myqueue queue   myqueue []
```
List queues
```shell
root@04491ade55ac:/# rabbitmqctl list_queues
Timeout: 60.0 seconds ...
Listing queues for vhost / ...
name    messages
myqueue 2
```
List consumers
```shell
root@04491ade55ac:/# rabbitmqctl list_consumers
Listing consumers in vhost / ...
queue_name      channel_pid     consumer_tag    ack_required    prefetch_count  active  arguments
myqueue <rabbit@04491ade55ac.1630720420.29948.1>        amq.ctag-WHMkZAwZyMPdnUwdkPQu8Q true    0       true    []
```
Print system status
```shell
root@04491ade55ac:/# rabbitmqctl status
Status of node rabbit@04491ade55ac ...
Runtime

OS PID: 21
OS: Linux
Uptime (seconds): 148023
Is under maintenance?: false
RabbitMQ version: 3.9.5
Node name: rabbit@04491ade55ac
Erlang configuration: Erlang/OTP 24 [erts-12.0.3] [source] [64-bit] [smp:8:8] [ds:8:8:10] [async-threads:1] [jit]
Erlang processes: 415 used, 1048576 limit
Scheduler run queue: 1
Cluster heartbeat timeout (net_ticktime): 60

Plugins

Enabled plugin file: /etc/rabbitmq/enabled_plugins
Enabled plugins:

 * rabbitmq_prometheus
 * prometheus
 * accept
 * rabbitmq_management
 * amqp_client
 * rabbitmq_web_dispatch
 * cowboy
 * cowlib
 * rabbitmq_management_agent

Data directory

Node data directory: /var/lib/rabbitmq/mnesia/rabbit@04491ade55ac
Raft data directory: /var/lib/rabbitmq/mnesia/rabbit@04491ade55ac/quorum/rabbit@04491ade55ac

Config files

 * /etc/rabbitmq/conf.d/10-default-guest-user.conf

Log file(s)

 * /var/log/rabbitmq/rabbit@04491ade55ac_upgrade.log
 * <stdout>

Alarms

(none)

Memory

Total memory used: 0.1643 gb
Calculation strategy: rss
Memory high watermark setting: 0.4 of available memory, computed to: 5.3085 gb

reserved_unallocated: 0.0909 gb (55.3 %)
code: 0.0351 gb (21.34 %)
other_system: 0.0283 gb (17.24 %)
other_proc: 0.0186 gb (11.31 %)
other_ets: 0.0032 gb (1.94 %)
plugins: 0.0018 gb (1.09 %)
atom: 0.0014 gb (0.87 %)
binary: 4.0e-4 gb (0.22 %)
mgmt_db: 3.0e-4 gb (0.2 %)
metrics: 2.0e-4 gb (0.15 %)
mnesia: 1.0e-4 gb (0.06 %)
quorum_ets: 0.0 gb (0.02 %)
msg_index: 0.0 gb (0.02 %)
queue_procs: 0.0 gb (0.01 %)
connection_other: 0.0 gb (0.0 %)
stream_queue_procs: 0.0 gb (0.0 %)
stream_queue_replica_reader_procs: 0.0 gb (0.0 %)
allocated_unused: 0.0 gb (0.0 %)
connection_channels: 0.0 gb (0.0 %)
connection_readers: 0.0 gb (0.0 %)
connection_writers: 0.0 gb (0.0 %)
queue_slave_procs: 0.0 gb (0.0 %)
quorum_queue_procs: 0.0 gb (0.0 %)
stream_queue_coordinator_procs: 0.0 gb (0.0 %)

File Descriptors

Total: 3, limit: 1048479
Sockets: 1, limit: 943629

Free Disk Space

Low free disk space watermark: 0.05 gb
Free disk space: 254.0405 gb

Totals

Connection count: 1
Queue count: 1
Virtual host count: 1

Listeners

Interface: [::], port: 15672, protocol: http, purpose: HTTP API
Interface: [::], port: 15692, protocol: http/prometheus, purpose: Prometheus exporter API over HTTP
Interface: [::], port: 25672, protocol: clustering, purpose: inter-node and CLI tool communication
Interface: [::], port: 5672, protocol: amqp, purpose: AMQP 0-9-1 and AMQP 1.0
```