// heredoc.js
var str = <<EOF
This is a multiline string.
Number of arguments passed to this
script is ${$ARG.length}
Arguments are ${$ARG}

Bye Heredoc!
EOF

print(str);
