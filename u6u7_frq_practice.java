1. 
(a)
public void addClimb(String peakName, int climbTime)
{
    climbList.add(new ClimbInfo(peakName, climbTime)); 
}
(b)
public void addClimb(String peakName, int climbTime)
{
    for(int i = 0; i < climbList.size(); i++)
    {
        if(climbList.get(i).getName().compareTo(peakName) > 0)
        {
            climbList.add(iw, new ClimbInfo(peakName, climbTime)); 
            return; 
        }
    }
    climbList.add(new ClimbInfo(peakName, climbTime)); 
}
(c)
no, yes. 

2. 
(a)
public int countNotInVocab(String[] wordArray)
{
    int num = 0; 
    for(int i = 0; i < wordArray.length; i++)
    {
        if(!findWord(wordArray[i]))
            num++; 
    }
    return num; 
}
(b)
public String[] notInVocab(String[] wordArray)
{
    String[] s = new String[countNotInVocab(wordArray)]; 
    int ind = 0; 
    for(int i = 0; i < wordArray.length; i++)
    {
        if(!findWord(wordArray[i]))
        {
            s[ind] = wordArray[i]; 
            ind++; 
        }
    }
    return s; 
}

3. 
(a)
public ArrayList<String> getDelimitersList(String[] tokens)
{
    ArrayList<String> as = new ArrayList<String>(); 
    for(int i = 0; i < tokens.length; i++)
    {
        if(tokens[i].equals(openDel) || tokens[i].equals(closeDel))
            as.add(tokens[i]); 
    }
    return as; 
}
(b)
public boolean isBalanced(ArrayList<String> delimiters)
{
    int currOpen = 0; 
    for(int i = 0; i < delimiters.size(); i++)
    {
        if(currOpen < 0)
            return false; 
        else 
        {
            if(delimiters.get(i).equals(openDel))
                currOpen++; 
            else if( delimiters.get(i).equals(closeDel))
                currOpen--; 
        }
    }
    if(currOpen == 0)
        return true; 
    else 
        return false; 
}

4.
(a)
public Digits(int num)
{
    while(num > 0)
    {
        digitList.add(0, num % 10); 
        num /= 10; 
    }
}
(b)
public boolean isStrictlyIncreasing()
{
    int former = digitList.get(0); 
    for(int i = 1; i < digitList.size(); i++)
    {
        if(digitList.get(i) <= former)
            return false; 
        former = digitList.get(i); 
    }
    return true; 
}

5.
(a)
private int getChargingCost(int startHour, int chargeTime)
{
    int tot = 0; 
    for(int i = startHour; i < startHour + chargeTime; i++)
    {
        tot += rateTable[i % 24]; 
    }
    return tot; 
}
(b)
public int getChargeStartTime(int chargeTime)
{
    int minval = Integer.MAX_VALUE, minind = 0; 
    for(int i = 0; i < 24; i++)
    {
        int temp = 0; 
        temp = getChargingCost(i, chargeTime);
        if(minval > temp)
        {
            minval = temp; 
            minind = i; 
        }
    }
    return minind; 
}

6.
(a)
public static int[] getCubeTosses(NumberCube cube, int numTosses)
{
    int[] g = new int[numTosses];
    for(int i = 0; i < numTosses; i++)
    {
        g[i] = cube.toss(); 
    }
    return g; 
}
(b)
public static int getLongestRun(int[] values)
{
    int maxind = 0, maxrun = 0, temprun = 0, tempind = 0;
    for(int i = 1; i < values.length; i++)
    {
        if(values[i-1] != values[i])
        {
            tempind = i; 
            if(maxrun < temprun)
            {
                maxrun = temprun; 
                maxind = tempind; 
            }
            temprun = 0; 
        }
        else if(values[i-1] == values[i])
        {
            temprun++; 
        }
    } 
    if(maxrun == 0)
        return -1; 
    else 
        return maxind; 
}

7.
(a)
public int getTotalBoxes()
{
    int total = 0; 
    for(int i = 0; i < orders.size(); i++)
    {
        total += orders.get(i).getNumBoxes(); 
    }
    return total; 
}
(b)
public int removeVariety(String cookieVar)
{
    int totalboxes = 0; 
    for(int i = 0; i < orders.size(); i++)
    {
        if(orders.get(i).getVariety().equals(cookieVar))
        {
            totalboxes += orders.get(i).getNumBoxes(); 
            orders.remove(i); 
            i--; 
        }
    }
    return totalboxes;
}

8.
(a)
public int countElectronicsByMaker(String maker)
{
    int totelecs = 0; 
    for(int i = 0; i < purchases.size(); i++)
    {
        Gizmo g = purchases.get(i); 
        if(g.getMaker().equals(maker) && g.isElectronic())
            totelecs++; 
    }
    return totelecs;
}
(b)
public boolean hasAdjacentEqualPair()
{
    if(purchases.size() < 2)
        return false; 
    for(int i = 1; i < purchases.size(); i++)
    {
        if(purchases.get(i-1).equals(purchases.get(i)))
            return true; 
    }
    return false; 
}

9.
(a)
public Reservation requestRoom(String guestName)
{
    for(int i = 0; i < room.length; i++)
    {
        if(room[i] == null)
        {
            Reservation r = new Reservation(guestName, i); 
            room[i] = r; 
            return r; 
        }
    }
    waitList.add(guestName); 
    return null; 
}
(b)
public Reservation cancelAndReassign(Reservation res)
{
    int minind = 0; 
    room[res.getRoomNumber()] = null; 
    if(waitList.size() > 0)
    {
        Reservation r = new Reservation(waitList.get(0), minind);
        room[minind] = r; 
        waitList.remove(0);
        return r; 
    }
    else 
        return null; 
}

10.
(a)
public int limitAmplitude(int limit)
{
    int tot = 0; 
    for(int i = 0; i < samples.length; i++)
    {
        if(Math.abs(samples[i]) > limit)
        {
            if(samples[i] > 0)
                samples[i] = limit; 
            else if(samples[i] < 0)
                samples[i] = -limit; 
            tot++; 
        }
    }
    return tot; 
}
(b)
public void trimSilenceFromBeginniing()
{
    int sampleind = 0; 
    for(int i = 0; i < samples.length; i++)
    {
        if(samples[i] != 0)
        {
            sampleind = i; 
            break; 
        }
    }
    if(sampleind <= 0)
        return; 
    int[] a = new int[samples.length - sampleind];
    int ind = 0; 
    for(int i = sampleind; i < samples.length; i++)
    {
        a[ind] = samples[i]; 
        ind++; 
    }
    samples = a; 
    return; 
}

11. 
(a)
public LogMessage(String message)
{
    int semiind = message.indexOf(":"); 
    machineId = message.substring(0, semiind); 
    description = message.substring(semiind + 1); 
}
(b)
public boolean containsWord(String keyword)
{
    if(description.equals(keyword) || description.indexOf(" " + keyword + " ") != -1 || description.indexOf(keyword + " ") != -1 || description.indexOf(" " + keyword) != -1)
        return true; 
    return false; 
}
(c)
public List<LogMessage> removeMessages(String keyword)
{
    ArrayList<LogMessage> l = new ArrayList<>(); 
    for(int i = 0; i < messageList.size(); i++)
    {
        if(messageList.get(i).containsWord(keyword))
        {
            l.add(messageList.get(i));
            messageList.remove(i); 
            i--;
        }
    }
    return l; 
}

12.
(a)
public static int getPeakIndex(int[] array)
{
    for(int i = 1; i < array.length - 1; i++)
    {
        if(array[i - 1] < arary[i] && array[i] > array[i + 1])
            return i; 
    }
    return -1; 
}
(b)
public static boolean isMountain(int[] array)
{
    int a = getPeakIndex(array);
    if(a == -1)
        return false; 
    for(int i = 0; i < a; i++)
    {
        if(array[i] > array[i + 1])
            return false; 
    }
    for(int i = a; i < array.length - 1; i++)
    {
        if(array[i] < array[i + 1])
            return false; 
    }
    return true; 
}

13.
(a)
private int getIndexForFit(NumberTile tile)
{
    if(board.size() == 0)
        return 0; 
    for(int i = 1; i < board.size(); i++)
    {
        NumberTile nt1 = board.get(i), nt2 = board.get(i - 1); 
        if(nt2.getRight() == tile.getLeft() && nt1.getLeft() == tile.getRight())
            return i; 
    }
    return -1; 
}
(b)
public boolean insertTile(NumberTile tile)
{
    int j = getIndexForFit(tile); 
    if(j == -1)
        return false; 
    else 
    {
        board.add(j, tile);
        return true; 
    }
}

14.
(a)
private boolean forwardMoveBlocked()
{
    if(pos == hall.length - 1 && facingRight)
        return true; 
    else if(pos == 0 && !facingRight)
        return true; 
    return false; 
}
(b)
private void move()
{
    if(hall[pos] > 0)
    {
        hall[pos]--; 
    }
    else if(hall[pos] == 0)
    {
        if(forwardMoveBlocked())
        facingRight = !facingRight; 
        else 
        {
            
            if(facingRight)
                pos++; 
            else 
                pos--; 
        }
    }
}
(c)
public int clearHall()
{
    int movel = 0; 
    while(!hallIsClear())
    {
        move(); 
        movel++; 
    }
    return movel; 
}

15. 
(a)
public boolean addRepair(int m, int b)
{
    for(int i = 0; i < schedule.size(); i++)
    {
        if(schedule.get(i).getBayNum() == b || schedule.get(i).getMechanicNum() == m)
            return false; 
    }
    return true; 
}
(b)
public ArrayList<Integer> availableMechanics()
{
    int[] n = new int[numberOfMechanics + 1]; 
    for(int i = 1; i <= numberOfMechanics; i++)
        n[i] = 1; 
    ArrayList<Integer> al = new ArrayList<>(); 
    for(int i = 0; i < schedule.size(); i++)
    {
        n[schedule.get(i).getMechanicNum()] = 0; 
    }
    for(int i = 1; i <= numberOfMechanics(); i++)
    {
        if(n[i] != 0)
            al.add(i); 
    }
    return al; 
}

16.
(a)
public void addReview(ProductReview prodReview)
{
    boolean a = true; 
    String prodRev = prodReview.getName(); 
    for(int i = 0; i < productList.size(); i++)
    {
        if(productList.get(i).getName().equals(prodRev))
        {
            a = false; 
            break; 
        }
    }
    if(a)
        productList.add(prodReview.getName()); 
    reviewList.add(prodReview);
}
(b)
public int getNumGoodReviews(String prodName)
{
    int num = 0; 
    for(int i = 0; i < reviewList.size(); i++)
    {
        if(reviewList.get(i).getName().equals(prodName) && reviewList.get(i).getReview().indexOf("best") != -1)
            num++; 
    }
    return num; 
}

17. 
(a)
public boolean record(int score)
{
    for(int i = 0; i < scoreList.size(); i++)
    {
        if(scoreList.get(i).getScore() == score)
        {
            scoreList.get(i).increment(); 
            return false; 
        }
    }
    for(int i = 0; i < scoreList.size(); i++)
    {
        if(scoreList.get(i).getScore() > score)
        {
            scoreList.add(i, new ScoreInfo(score)); 
            break; 
        }
    }
    return true; 
}
(b)
public void recordScores(int[] stuScores)
{
    for(int i = 0; i < stuScores.length; i++)
    {
        record(stuScores[i]); 
    }
}

18.
(a)
public static boolean isSelfDivisor(int number)
{
    ArrayList<Integer> al = new ArrayList<>(); 
    int num = number; 
    while(num > 0)
    {
        al.add(num % 10);
        num /= 10; 
    }
    for(int i = 0; i < al.size(); i++)
    {
        if(number % al.get(i) != 0)
            return false; 
    }
    return true; 
}
(b)
public static int[] firstNumSelfDivisors(int start, int num)
{
    int ind = 0, currnum = start; 
    int[] a = new int[num]; 
    while(ind < num)
    {
        if(isSelfDivisor(currnum))
        {
            a[ind] = currnum; 
            ind++; 
        }
        currnum++; 
    }
    return a; 
}

19.
(a)
public DownloadInfo getDownloadInfo(String title)
{
    for(int i = 0; i < downloadList.size(); i++)
    {
        if(downloadList.get(i).getTitle().equals(title))
            return downloadList.get(i); 
    }
    return null; 
}
(b)
public void updateDownloads(List<String> titles)
{
    for(int i = 0; i < titles.size(); i++)
    {
        if(getDownloadInfo(titles.get(i)) == null)
            downloadList.add(new DownloadInfo(titles.get(i))); 
        else 
        {
            getDownloadInfo(titles.get(i)).incrementTimesDownloaded(); 
        }
    }
}

20.
(a)
public int getValueAt(int row, int col)
{
    for(int i = 0; i < entries.size(); i++)
    {
        SparseArrayEntry sa = entries.get(i);
        if(sa.getRow() == row && sa.getCol() == col)
            return sa.getValue(); 
    }
    return 0;
}
(b)
public void removeColumn(int col)
{
    for(int i = 0; i < entries.size(); i++)
    {
        SparseArrayEntry sae = entries.get(i); 
        if(sae.getNumCols() == col)
            entries.remove(i); 
        else if(sae.getNumCols() > col)
            entries.set(i, new SparseArrayEntry(sae.getRow(), sae.getCol() - 1, sae.getValue()));
    }
}

21.
(a)
public String decodeString(ArrayList<StringPart> parts)
{
    String tot = "";
    for(int i = 0; i < parts.size(); i++)
    {
        int s = parts.get(i).getStart(); 
        tot += masterString.substring(s, s + parts.get(i).getLength()); 
    }
    return tot; 
}
(b)
public ArrayList<StringPart> encodeString(String word)
{
    ArrayList<StringPart> a = new ArrayList<>(); 
    String ward = word; 
    while(ward.length() > 0)
    {
        StringPart s = findPart(ward); 
        a.add(s); 
        ward = ward.substring(s.getLength()); 
    }
    return a;
}

22.
(a)
public static int totalLetters(List<String> wordList)
{
    int tot = 0; 
    for(int i = 0; i < wordList.size(); i++)
    {
        tot += wordList.get(i).length(); 
    }
    return tot; 
}
(b)
public static int basicGapWidth(List<String> wordList, int formattedLen)
{
    int lefts = formattedLen - totalLetters(wordList); 
    return lefts / (wordList.size() - 1); 
}
(c)
public static int leftoverSpaces(List<String> wordList, int formattedLen)
{
    int lefts = formattedLen - totalLetters(wordList); 
    return lefts - basicGapWidth(wordList, formattedLen) * (wordList.size() - 1); 
}

23.
(a)
public double getScore(ArrayList<String> key)
{
    double total = 0; 
    for(int i = 0; i < key.size(); i++)
    {
        if(key.get(i).equals(answers.get(i)))
            total += 1;
        else 
            total -= 0.25; 
    }
    return total;
}
(b)
public String highestScoringStudent(ArrayList<String> key)
{
    int maxscore = Integer.MIN_VALUE;
    String s = ""; 
    for(int i = 0; i < sheets.size(); i++)
    {
        if(sheets.get(i).getScore(key) > maxscore)
        {
            maxscore = sheets.get(i).getScore(key); 
            s = sheets.get(i).getName(); 
        }
    }
    return s; 
}

24.
(a)
private double average(int first, int last)
{
    int tot = 0; 
    for(int i = first; i <= last; i++)
        tot += scores[i];
    return (double) tot / (last - first + 1); 
}
(b)
private boolean hasImproved()
{
    for(int i = 1; i < scores.length; i++)
    {
        if(scores[i - 1] > scores[i])
            return false; 
    }
    return true; 
}
(c)
public double finalAverage()
{
    if(hasImproved())
    {
        if((double) scores.length / 2.0 - scores.length / 2 > 0)
            return average(scores.length / 2 + 1, scores.length - 1);
        else 
            return average(scores.length / 2, scores.length - 1); 
    }
    else 
        return average(0, scores.length - 1); 
}

25. 
(a)
public boolean conflictsWith(Appointment other)
{
    if(getTime().overlapsWith(other.getTime()))
        return true; 
    return false; 
}
(b)
public void clearConflicts(Appointment appt)
{
    for(int i = 0; i < apptList.size(); i++)
    {
        if(apptList.get(i).conflictsWith(appt))
        {
            apptList.remove(i);
            i--; 
        }
    }
}
(c)
public boolean addAppt(Appointment appt, boolean emergency)
{
    if(emergency)
    {
        cleaerConflicts(appt);
        apptList.add(appt); 
        return true; 
    }
    else
    {
        for(int i = 0; i < apptList.size(); i++)
        {
            if(apptList.get(i).conflictsWith(appt))
                return false; 
        }
        apptList.add(appt);
        return true; 
    }
}

26. 
(a)
public TokenPass(int playerCount)
{
    board = new int[playerCount];
    currentPlayer = (int)(Math.random() * playerCount); 
    for(int i = 0; i < playerCount; i++)
    {
        board[i] = (int)(Math.random() * 11);
    }
}
(b)
public void distributeCurrentPlayerTokens()
{
    int ind = currentPlayer + 1; 
    int tokens = board[currentPlayer];
    board[currentPlayer] = 0; 
    while(token > 0)
    {
        token--; 
        board[ind % board.length]++; 
        ind++; 
    }
}

27.
(a)
public boolean isLevelTrailSegment(int start, int end)
{
    int maxind = Integer.MIN_VALUE, minind = Integer.MAX_VALUE; 
    for(int i = start; i <= end; i++)
    {
        if(markers[i] > maxind) maxind = markers[i];
        if(markers[i] < minind) minind = markers[i]; 
    }
    if(Math.abs(maxind - minind) > 10)
        return false; 
    return true; 
}
(b)
public boolean isDifficult()
{
    int tot = 0; 
    for(int i = 1; i < markers.length; i++)
    {
        if(Math.abs(markers[i-1] - markers[i]) >= 30)
            tot++; 
    }
    if(tot >= 3)
        return true; 
    return false; 
}

29.
(a)
private String recombine(String word1, String word2)
{
    String tot = ""; 
    tot += word1.substring(0, word1.length / 2); 
    tot += word2.substring(word2.length / 2); 
    return tot; 
}
(b)
private String[] mixedWords(String[] words)
{
    String[] a = new String[words.length]; 
    for(int i = 0; i < words.length; i+=2)
    {
        a[i] = recombine(words[i], word[i+1]); 
        a[i+1] = recombine(words[i+1], words[i]); 
    }
    return a; 
}

30.
(a)
public int numWordsOfLength(int len)
{
    int tot = 0; 
    for(int i = 0; i < myList.size(); i++)
    {
        if(myList.get(i).length == len)
            tot++; 
    }
    return tot; 
}
(b)
public void removeWordsOfLength(int len)
{
    for(int i = 0; i < myList.size(); i++)
    {
        if(myList.get(i).length == len)
        {
            myList.remove(i);
            i--; 
        }
    }
}

31.
(a)
public WordPairList(String[] words)
{
    for(int i = 0; i < words.length; i++)
    {
        for(int j = 0; j < words.length; j++)
        {
            allPairs.add(new WordPair(words[i], words[j])); 
        }
    }
}
(b)
public int numMatches()
{
    int tot = 0; 
    for(int i = 0; i < allPairs.size(); i++)
    {
        if(allPairs.get(i).getFirst().equals(allPairs.get(i).getSecond()))
            tot++; 
    }
    return tot; 
}