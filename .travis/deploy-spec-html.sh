#!/bin/bash

set -euo pipefail

BASEDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )/../" && pwd )"

echo "Creating site archive..."
cd ${BASEDIR}/spec/target/generated-docs/
zip -q -r ${BASEDIR}/site.zip *

echo "Uploading archive..."
cd ${BASEDIR}
curl -s -H "Content-Type: application/zip" \
     -H "Authorization: Bearer ${NETLIFY_TOKEN}" \
     --data-binary "@site.zip" \
     https://api.netlify.com/api/v1/sites/a36b2588-c345-47ea-95ed-3dbcfcd5cee9/deploys \
     > /dev/null

echo "Done"
