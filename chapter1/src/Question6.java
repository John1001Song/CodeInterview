public class Question6 {

    // https://stackoverflow.com/questions/25882480/rotating-a-nxn-matrix-in-java
    // as described in the stackoverflow, the logic is more important than the code.
    // idea: rotate the outer boundary, then the inner
    // example in the link:
    // 4x4 matrix:
    // ABCD
    // EFGH
    // IJKL
    // MNOP
    // first rotation changes outer elements and inner elements keeps un-changed:
    //  MIEA
    //  N  B
    //  O  C
    //  PLHD
    // then second rotation changes the inner elements:
    // JF
    // KG
    // then, the combine the outer and inner results:
    //  MIEA
    //  NJFB
    //  OKGC
    //  PLHD

    // here is the code from the book:
    public void rotate(int[][] matrix, int n) {
        // why ++layer not layer++?
        for (int layer = 0; layer < n/2; ++layer) {
            int first = layer;
            // not sure what does this line 31 mean
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                // don't know what does the offset mean
                int offset = i - first;
                // save top
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last]= top;
            }
        }
    }
}
