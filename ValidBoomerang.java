class ValidBoomerang
{
    public boolean isBoomerang(int[][] points) 
    {
        // Compute vector points for three points - {A,B,C}
        int[] A = points[0];
        int[] B = points[1];
        int[] C = points[2];
        
        // Compute cross-prod quantities
        int cross_prod_p1 = ((B[0] - A[0]) * (C[1]-A[1]));
        int cross_prod_p2 = ((B[1] - A[1]) * (C[0]-A[0]));
        int cross_prod = cross_prod_p1 - cross_prod_p2;
        if(cross_prod != 0)
            return true;
        return false;
    }
}