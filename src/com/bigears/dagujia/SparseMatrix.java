package com.bigears.dagujia;

// Student name:
// Student ID  :

import java.util.Map;
import java.util.TreeMap;

public class SparseMatrix 
{
    // value < THRESHOLD is considered to be zero
    private static final double THRESHOLD = 0.000000001;  
    private static final int DEFAULT_SIZE = 8;  // DO NOT change this constant
    
    // Instance variables
    private int row, col, nElm;
    private DataItem[] items;
    
    public SparseMatrix(int r, int c)  // default constructor
    {
        items = new DataItem[DEFAULT_SIZE];
        row = r;
        col = c;
        nElm = 0;
    }
    
    private SparseMatrix(int r, int c, int n, DataItem[] d)  // private constructor
    {
        row = r;
        col = c;
        nElm = n;
        items = d;
    }

    //------------------------------------------ methods to be implemented by you
    
    // Precondition: row index r and column index c are valid.
    // Set the value of matrix[r][c] to v.
    public void setValue(int r, int c, double v)
    {        
        /*
         * If the element m[r][c] is non-zero (can be found in items[])
         *    - change its value to v
         *    - if v is zero (i.e. absolute value of v is < THRESHOLD)
         *          remove the corresponding entry from items[]
         * else if v is non-zero
         *    - insert the entry into items[]
         * 
         * update nElm accordinly
         */
		DataItem dataItem = new DataItem(r, c, v);

		// 如果set的数原来里面没有，则插入
		if (getValue(r, c) == 0 && Math.abs(v) >= THRESHOLD) {
			// 找到插入的位置
			int insert = nElm;
			for (int i = 0; i < nElm; i++) {
				if (items[i].row > r || (items[i].row == r && items[i].col >= c)) {
					insert = i;
					break;
				}
			}

			// 重新构建一个新的临时数组
			DataItem[] temp = new DataItem[nElm + 1];
			System.arraycopy(items, 0, temp, 0, insert);
			temp[insert] = dataItem;
			System.arraycopy(items, insert, temp, insert + 1, nElm - insert);
			items = temp;
			nElm++;
		} else {
			for (int i = 0; i < nElm; i++) {
				if (items[i].row == r && items[i].col == c) {
					// 如果插入的v为0，则将该位置从items数组中删除
					if (Math.abs(v) < THRESHOLD) {
						DataItem[] temp = new DataItem[nElm - 1];
						System.arraycopy(items, 0, temp, 0, i);
						System.arraycopy(items, i + 1, temp, i, nElm - i - 1);
						items = temp;
						nElm--;
					} else {
						// 如果插入的v不为0，则替换原来的
						items[i] = dataItem;
					}
					break;
				}
			}
		}
		// Arrays.sort(items,new DataItemComparator());
    }
    
    // Precondition: dimensions of other is same as this.
    // Return a new SparseMatrix object that represents this + other.
    // The contents of this and other should not be changed by the add method.
	public SparseMatrix add(SparseMatrix other) {
		// When you implement this method, do not use the setValue() method.
		
		// 如果other中有不为0的元素
		if (other != null && other.nElm > 0) {

			// 构造一个treeMap，此map中key为row+col的字符串，如：row=0，col=3,则key=03
			// treeMap默认是按照key升序排序，所以我们用row+col组装的key存进此map后，默认的排序及为我们想要的顺序。
			TreeMap<String, DataItem> map = new TreeMap<String, DataItem>();

			// 遍历items存入treeMap
			for (DataItem item : items) {
				map.put(String.valueOf(item.row) + String.valueOf(item.col), item);
			}

			// 遍历other.items
			for (DataItem item : other.items) {
				String key = String.valueOf(item.row) + String.valueOf(item.col);
				DataItem temp = map.get(key);

				// 如果temp为不空，说明该DataItem在原有的Matrix中有，执行value相加，
				// 相加结果为0的话，就在map中移除
				// 相加结果不为0的话，构造一个新的DataItem对象存入
				if (temp != null) {
					if (Math.abs(temp.value + item.value) < THRESHOLD) {
						map.remove(key);
					} else {
						map.put(key, new DataItem(item.row, item.col, temp.value + item.value));
					}
				} else {
					// 如果temp为空，说明没有，则插入
					map.put(key, item);
				}
			}

			// 遍历treeMap，构造我们需要的DataItem[]
			int size = map.size();
			DataItem[] dataItem = new DataItem[size];
			int i = 0;
			for (Map.Entry<String, DataItem> m : map.entrySet()) {
				dataItem[i] = m.getValue();
				i++;
			}

			// 返回新的SparseMatrix
			return new SparseMatrix(row, col, size, dataItem);
		}
		return new SparseMatrix(row, col, nElm, items); // dummy return statement, replace it by your own codes
	}
    
    //------------------------------------------ methods given to you
    
    public int getNumOfElm()
    {
        return nElm;
    }
    
    public double getValue(int r, int c)
    {
        DataItem d = binSearch(r, c);  
        if (d != null)
            return d.value;
        else
            return 0;
    }        
    
    private DataItem binSearch(int r, int c)
    {
        int low = 0;
        int high = nElm - 1;
        
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (items[mid].row == r && items[mid].col == c)
                return items[mid];
            
            if (items[mid].row < r || (items[mid].row == r && items[mid].col < c))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
    
    public String toString()
    {
        String s = "Sparse Matrix [" + row + ", " + col
                   + "] = {";

        if (nElm > 0)
        {
            for (int i = 0; i < nElm-1; i++)        
                s = s + "(" + items[i].row + ", " + items[i].col + ", " + items[i].value + "), ";
                
            s = s + "(" + items[nElm-1].row + ", " + items[nElm-1].col + ", " + items[nElm-1].value + ")";
        }
        
        s = s + "}";
        return s;
    }   
    
    
 
    
    
}



//class DataItemComparator implements Comparator<DataItem>{
//
//	@Override
//	public int compare(DataItem o1, DataItem o2) {
//		if(o1 == null || o2 ==null)
//			return -1;
//		int i = 0;
//		i = o1.row - o2.row;
//		if(i == 0){
//			if(o1.col != o2.col){
//				return o1.col-o2.col;
//			}
//		}else{
//			return i;
//		}
//		return 1;
//	}
//	
//	
//}





//------------------------------------------  DO NOT modify the class DataItem
class DataItem 
{
    protected int row;
    protected int col;
    protected double value;
    
    public DataItem(int r, int c, double v)
    {
        row = r;
        col = c;
        value = v;
    }    
    
    public DataItem(DataItem d)
    {
        row = d.row;
        col = d.col;
        value = d.value;
    }
}
