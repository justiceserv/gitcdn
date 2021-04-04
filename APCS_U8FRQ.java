1-A
private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
{
    if(blackSquares[r][c]) return true; 
    if(r == 0 || c == 0) return true; 
    if(!blackSquares[r][c-1] || !blackSquares[r - 1][c]) return true; 
    return false; 
}

1-B
public Crossword(boolean[][] blackSquares)
{
    int r = blackSquares.length; 
    int c = blackSquares[0].length; 
    puzzle = new Square[r][c];

    int num = 0; 

    for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
            boolean isBlack = blackSquares[i][j];
            if(isBlack)
                puzzle[i][j] = new Square(true, 0); 
            else
            {
                if(toBeLabeled(i,j,blackSquares))
                    puzzle[i][j] = new Sqaure(false, num++);
                else
                    puzzle[i][j] = new Square(false, 0); 
            }
        }
    }
}

2-A
public static int arraySum(int[] arr)
{
    int sum = 0; 
    for(int i = 0; i < arr.length; i++)
    {
        sum += arr[i]; 
    }
    return sum; 
}

2-B
public static int[] rowSums(int[][] arr2D)
{
    int[] a = new int[arr2D.length];  
    for(int i = 0; i < arr2D.length; i++)
    {
        for(int j = 0; j < arr2D[0].length; j++)
        {
            a[i] += arr[i][j]; 
        }
    }
    return a; 
}

2-C 
public static boolean isDiverse(int[][] arr2D)
{
    int[] a = rowSums(arr2D); 
    for(int i = 0; i < a.length; i++)
    {
        for(int j = 0; j < a.length; j++)
        {
            if(i != j && a[i] == a[j])
                return false; 
        }
    }
    return true; 
}

3-A 
public int countWhitePixels()
{
    int sum = 0; 
    for(int i = 0; i < pixelValues.length; i++)
    {
        for(int j = 0; j < pixelValues[0].length; j++)
        {
            if(pixelValues[i][j] == WHITE)
                sum++; 
        }
    }
    return sum; 
}

3-B 
public void processImage()
{
    for(int i = 0; i < pixelValues.length - 2; i++)
    {
        for(int j = 0; j < pixelValues[0].length - 2; j++)
        {
            pixelValues[i][j] -= pixelValues[i + 2][j + 2]; 
            if(pixelValues[i][j] < BLACK)
                pixelValues[i][j] = BLACK; 
        }
    }
}

4-A
public String mostValuableNeighbor(int r, int c)
{
    int goodneighbor = Integer.MIN_VALUE; 
    int goodneighind[2] = {0, 0}; 
    for(int i = r - 1; i < r + 1; i++)
    {
        for(int j = c - 1; j < c + 1; j++)
        {
            if(grid[i][j].getvalue() > goodneighbor && i != r && j != c)
            {
                goodneighbor = grid[i][j].getvalue(); 
                goodneighind[0] = i; 
                goodneighind[1] = j; 
            }
        }
    }
    return grid[goodneighind[0]][goodneighind[1]].getName(); 
}

4-B 
public double findAverage()
{
    int sumind = 0, sum = 0; 
    for(int i = 0; i < grid.length; i++)
    {
        for(int j = 0; j < grid[0].length; j++)
        {
            sum += grid[i][j].getvalue(); 
            sumind++; 
        }
    }
    return (double) sum / sumind; 
}

5-A
public static int[] getColumn(int[][] arr2D, int c)
{
    int[] col = new int[arr2D.length];

    for(int i = 0; i < col.length; i++)
    {
        col[i] = arr2D[i][c];
    }
    return col;
}

5-B
public static boolean isLatin(int[][] square)
{
    if(containsDuplicate(square[0]))
        return false; 
    for(int r = 1; r < square.length; r++)
    {
        if( !hasAllValues( square[0], square[r] ))
            return false;
    }
    for(int c = 0; c < square[0].length; c++)
    {
        if( !hasAllValues(square[0], getColumn(square, c)) )
            return false; 
    }
    return true; 
}

6-A 
public LightBoard(int numRows, int numCols)
{
    lights = new boolean[numRows][numCols]; 
    for(int i = 0; i < numRows; i++)
    {
        for(int j = 0; j < numCols; j++)
        {
            if(Math.random() < 0.4)
                lights[i][j] = true; 
            else
                lights[i][j] = false; 
        }
    }
}

6-B 
public boolean evaluateLight(int row, int col)
{
    if(lights[row][col])
    {
        int tot = 0; 
        for(int i = 0; i < col; i++)
        {
            if(lights[row][i])
                tot++; 
        }
        if(tot % 2 == 0)
            return false; 
        else
            return true; 
    }
    else
    {
        int tot = 0; 
        for(int i = 0; i < col; i++)
        {
            if(lights[row][i])
                tot++; 
        }
        if(tot % 3 == 0)
            return true; 
        else 
            return false; 
    }
}

7-A 
private void fillBlock(String str)
{
    for(int i = 0; i < numRows; i++)
    {
        for(int j = 0; j < numCols; j++)
        {
            int ind = i * numCols + j; 
            if(ind < str.length())
            {
                letterBlock[i][j] = str.substring(ind, ind + 1); 
            }
            else 
            {
                letterBlock[i][j] = "A"; 
            }
        }
    }
}

7-B 
public String encryptMessage(String message)
{
    int blocklength = numRows * numCols; 
    String encrypted = ""; 
    for(int i = 0; i <= message.length() / blocklength; i++)
    {
        if(message.length() == 0) break;
        fillBlock(message);
        encrypted += encryptBlock();
        message = message.substring(blocklength);  
    }
    return encrypted; 
}

8-A
public SeatingChart(List<Student> studentList, int rows, int cols)
{
    seats = new Student[rows][cols]; 
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < cols; j++)
        {
            
        }
    }
}