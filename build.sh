#!/bin/bash
set -e
mvn clean install package
bash <(curl -s https://codecov.io/bash)