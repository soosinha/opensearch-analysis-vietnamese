#!/bin/bash
# setting up prerequisites

cd /usr/share/opensearch

yes | ./bin/opensearch-plugin install file:./plugin/opensearch-analysis-vietnamese-$OPENSEARCH_VERSION.zip

/usr/local/bin/docker-entrypoint.sh opensearchwrapper