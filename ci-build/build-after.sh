git diff --exit-code --quiet && return

git commit -m "Upgrading version ref. in create-project.sh [ci skip]" create-project.sh
NEEDS_PUSH=true
