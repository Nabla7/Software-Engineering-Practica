
/*
 * Runtime method.
 *
 * Method that takes an array 'arr' and replaces every element in that array with
 * the value 'replacement'.
 */
method erase_array(arr: array<int>, replacement: int) returns () modifies arr
    requires arr.Length >= 0
    // TODO: post-condition that all elements in the array are equal to 'replacement'
    ensures forall i :: 0 <= i < arr.Length ==> arr[i] == replacement
{
    var i := 0;

    while(i < arr.Length)
        // TODO: invariant
        invariant 0 <= i <= arr.Length
        invariant forall j :: 0 <= j < i ==> arr[j] == replacement
        // TODO: variant
        decreases arr.Length - i
    {
        arr[i] := replacement;

        i := i + 1;
    }

    return;

}
