# Introduction

## Events

An **event** is a set of values associated with a timestamp. It is a single entry of data and can have one or multiple lines. An event can be a text document, a configuration file, an entire stack trace, and so on.

## Host, Source, and Source Type

Events with the same source types can come from different sources. For example, events from the file

```
source=/var/log/messages
```

and from a syslog input port

```
source=UDP:514
```

often share the source type,

```
sourcetype=linux_syslog
```

## Indexes

When data is added, Splunk software parses the data into individual events, extracts the timestamp, applies line-breaking rules, and stores the events in an  **index** . You can create new indexes for different inputs. By default, data is stored in the “main” index. Events are retrieved from one or more indexes during a search.

# Search Processing Language (SPL)

A Splunk search is a series of commands and arguments. Commands are chained together with a pipe “|” character to indicate that the output of one command feeds into the next command on the right.

```
search | command1 arguments1 | command2 arguments2 | ...
```

At the start of the search pipeline, is an implied search command to retrieve events from the index. Search requests are written with keywords, quoted phrases, Boolean expressions, wildcards, field name/value pairs, and comparison expressions. The AND operator is implied between search terms. For example:

![1719934769778](image/README/1719934769778.png)


## Search Command

The SPL2 `search` command retrieves events from one or more index datasets, or filters search results that are already in memory.

You can retrieve events from your datasets using keywords, quoted phrases, wildcards, and field-value expressions. When the `search` command is not the first command in the pipeline, it is used to filter the results of the previous command.

index=<your_index> sourc=<your_source> | search EventCode=100

Filtering Results
Allows for users to filter results in query. For example show results
where event code = 100
