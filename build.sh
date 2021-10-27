#!/bin/bash
set -e
mvn clean install package spotbugs:spotbugs -Dpg_user=postgres
bash <(curl -s https://codecov.io/bash)