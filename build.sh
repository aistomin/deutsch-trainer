#!/bin/bash
set -e
mvn clean install package -Dpg_user=postgres
bash <(curl -s https://codecov.io/bash)