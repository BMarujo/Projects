make -C ../build

#INPUT_FILE="../examples/ex06-random-fill.cfg"
INPUT_FILE="../examples/ex05.cfg"
MY_OUTPUT="my.txt"
BIN_OUTPUT="bin.txt"
MYFUNCTIONS=(101)  # Add or remove function IDs as needed

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
#diff $MY_OUTPUT $BIN_OUTPUT
