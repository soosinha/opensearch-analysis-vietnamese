Vietnamese Analysis Plugin for OpenSearch
========================================

Vietnamese Analysis plugin integrates Vietnamese language analysis into OpenSearch.

The plugin provides the `vi_analyzer` analyzer and `vi_tokenizer` tokenizer. The `vi_analyzer` is composed of the `vi_tokenizer` tokenizer, the `lowercase` and `stop` filter.


## Installation on OpenSearch

In order to install the plugin, choose a version in [releases](https://github.com/soosinha/opensearch-analysis-vietnamese/releases) page then run:

```sh
bin/opensearch-plugin install link/to/binary/version
```
## Build from Source
Check this post: [How to build OpenSearch Vietnamese Analysis Plugin](http://duydo.me/how-to-build-elasticsearch-vietnamese-analysis-plugin/)

## Sample Usage

Sample request
```
GET localhost:9200/analyzer
{
	"analyzer": "vi_analyzer",
	"text": "một chuỗi tiếng việt"
}
```

Result
```json
{
    "tokens": [
        {
            "token": "một",
            "start_offset": 0,
            "end_offset": 3,
            "type": "<PHRASE>",
            "position": 0
        },
        {
            "token": "chuỗi",
            "start_offset": 4,
            "end_offset": 9,
            "type": "<PHRASE>",
            "position": 1
        },
        {
            "token": "tiếng",
            "start_offset": 10,
            "end_offset": 15,
            "type": "<PHRASE>",
            "position": 2
        },
        {
            "token": "việt",
            "start_offset": 16,
            "end_offset": 20,
            "type": "<PHRASE>",
            "position": 3
        }
    ]
}
```

If testing failed, consider restarting the opensearch service to reload the plugin.

## Compatible Versions
| Vietnamese Analysis Plugin | OpenSearch |
| -------------------------- | ------------- |
| master                     | 1.0.0         |
| 1.0.0                      | 1.0.0         |

## Thanks to
- [Lê Hồng Phương](http://mim.hus.vnu.edu.vn/phuonglh/) for his VnTokenizer library
- [JetBrains](https://www.jetbrains.com) has provided a free license for their great tool: [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## License
    
    This software is licensed under the Apache 2 license, quoted below.

    Licensed under the Apache License, Version 2.0 (the "License"); you may not
    use this file except in compliance with the License. You may obtain a copy of
    the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
    License for the specific language governing permissions and limitations under
    the License.
