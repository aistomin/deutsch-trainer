#!/bin/bash
set -e
mvn clean install package -Ddt.db.user=postgres
bash <(curl -s https://codecov.io/bash)