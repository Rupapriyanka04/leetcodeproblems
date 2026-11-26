class Solution {
    public boolean canAliceWin(int n) {
        int stones = n;
        int remove = 10;
        boolean aliceTurn = true;

        while (stones >= remove) {
            stones -= remove;
            remove--;

            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}
