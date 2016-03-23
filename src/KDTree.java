
import java.util.ArrayList;
import java.util.Stack;

import ch3KNN.Node;

/**
 * 
 */

/**
 * @author fang
 *
 */
public class KDTree {
	/**
	 * 快速排序<br/>
	 * <ul>
	 * <li>从数列中挑出一个元素，称为“基准”</li>
	 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
	 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>
	 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
	 * </ul>
	 * 
	 * @param numbers
	 * @param start
	 * @param end
	 */
	private void quickSort(ArrayList<Point> pTs, int start, int end, int l) {
		if (start < end) {
			double base = pTs.get(start).getX().get(l); // 选定的基准值（第一个数值作为基准值）
			Point temp; // 记录临时中间值
			int i = start, j = end;
			do {
				while ((pTs.get(i).getX().get(l) < base) && (i < end))
					i++;
				while ((pTs.get(j).getX().get(l) > base) && (j > start))
					j--;
				if (i <= j) {
					temp = pTs.get(i);
					pTs.set(i, pTs.get(j));
					pTs.set(j, temp);
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(pTs, start, j, l);
			if (end > i)
				quickSort(pTs, i, end, l);
		}
	}

	/**
	 * 按照第l维的值进行排序
	 * 
	 * @param pTs
	 * @param l
	 */
	private ArrayList<Integer> SortByI(ArrayList<Point> pTs, int l) {
		int size = pTs.size();
		ArrayList<Integer> tag = new ArrayList<>(size);
		ArrayList<Point> temArray = new ArrayList<>(size);
		for (Point point : pTs) {
			temArray.add(point);
		}
		
		return tag;
	}

	/**
	 * 
	 */
	public KDTree(ArrayList<Point> pTs) {
		ArrayList<Node<Point>> arrayList = new ArrayList<>();
		for (Point t : pTs) {
			arrayList.add(new Node<Point>(t));
		}
		int K = pTs.get(0).getX().size();// k维数据
		int N = pTs.size();
		int dept = 0;
		ArrayList<ArrayList<Integer>> sortOrder = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			sortOrder.add(SortByI(pTs, i));
		}
		Stack<Point> stack = new Stack<>();

	}
}
