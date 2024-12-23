make -C ../build

#INPUT_FILE="../examples/ex06-random-fill.cfg"
INPUT_FILE="../examples/ex05.cfg"
MY_OUTPUT="my.txt"
BIN_OUTPUT="bin.txt"
MYFUNCTIONS=(101 102 103 104 105 106 201 202 203 204 206 207 302 303 304 305 306 307 308 401 402 403 404 405 406 407 408 409 410 501 502 503 504 505 601 602 603 604 605)  # Add or remove function IDs as needed
# casos particulares -> 205 301
R_OPTIONS=""
for func in "${MYFUNCTIONS[@]}"; do
    R_OPTIONS+=" -r$func"
done

echo "Running with your functions..."
./main -i $INPUT_FILE -b $R_OPTIONS -o $MY_OUTPUT
echo ""
echo "Output written to $MY_OUTPUT"

echo ""
echo ""
echo ""

echo "Running with teacher's functions..."
./main -i $INPUT_FILE -b -o $BIN_OUTPUT
echo ""
echo "Output written to $BIN_OUTPUT"

meld $MY_OUTPUT $BIN_OUTPUT
