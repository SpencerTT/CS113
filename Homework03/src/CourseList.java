/**
 * CourseList.java : This class contains a list of CourseNodes starting with the head and
 * 		has a size that is controlled by the CourseList methods.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class CourseList
{
	private CourseNode head;
	private int size = 0;
	
	//No getter/setter for head by design
	//Also, no setSize() by design

	/**
	 * Getter for size
	 * @return size The size of the list
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * String representation of a CourseList
	 * @return result The string representation of a CourseList
	 */
	public String toString()
	{
		String result = "";
		CourseNode pos = head;
		for (int x = 0; x < size; x++)
		{
			result += pos.getName() + " => ";
			pos = pos.getNext();
		}	
		return result;
		
	}

	/**
	 * This method adds a CourseNode to the bottom of the list
	 * @param name The name to be added to the bottom of the list
	 */
	public void addBot(String name)
	{
		size++;
		if (head == null)
		{
			head = new CourseNode(name, null);
		}
		else
		{
			CourseNode botNode = head;
			while(botNode.getNext() != null)
			{
				botNode = botNode.getNext();
			}
			CourseNode node = new CourseNode(name, null);
			botNode.setNext(node);
		}
	}

	/**
	 * This method adds a CourseNode to the top of the list
	 * @param name The name to be added to the top of the list
	 */
	public void addTop(String name)
	{
		size++;
		if (head == null)
		{
			head = new CourseNode(name, null);
		}
		else
		{
			head = new CourseNode(name, head);
		}
	}

	/**
	 * This method removes a CourseNode from the top of the list
	 * @return result The name that was removed from the top of the list
	 */
	public String removeTop()
	{
		String result = null;
		if (head != null)
		{
			size--;
			result = head.getName();
			if (head.getNext() != null)
			{
				head = head.getNext();
			}
			else
			{
				head = null;
			}
		}
		return result;
	}
	
	/**
	 * This method removes a CourseNode by name
	 * @param name The name to search the list for a match
	 * @return true if the name was found and removed, otherwise false
	 */
	public boolean removeName(String name)
	{
		int pos = 0;
		CourseNode cNode = null;
		if (head != null)
		{
			cNode = head;
		}
		else
		{
			return false;
		}

		while (pos < size)
		{
			if (cNode.getName().equals(name))
			{
				size--;
				if (cNode.getNext() != null)
				{
					CourseNode prev = head;
					if (cNode == head)
					{
						removeTop();
					}
					else
					{
						while (prev.getNext() != cNode)
						{
							prev = prev.getNext();
						}
						prev.setNext(cNode.getNext());
					}
				}
				else
				{
					CourseNode prev = head;
					if (cNode == head)
					{
						removeTop();
					}
					else
					{
						while (prev.getNext() != cNode)
						{
							prev = prev.getNext();
						}
						prev.setNext(null);
					}
				}
				return true;
			}
			if (cNode.getNext() != null)
			{
				cNode = cNode.getNext();
			}
			pos++;
		}
		return false;
	}

	/**
	 * CourseNode.java : This class contains the data (name) and link (next) for a CourseNode
	 * 
	 * @author Spencer Thompson
	 * @version 1.0
	 *
	 */
	public class CourseNode
	{
		private String name;
		private CourseNode next;

		/**
		 * 2-arg constructor to make a new CourseNode
		 * @param name The node's data
		 * @param next The node's link
		 */
		public CourseNode(String name, CourseNode next)
		{
			this.name = name;
			this.next = next;
		}

		/**
		 * Setter for name
		 * @param name The node's name
		 */
		public void setName(String name)
		{
			this.name = name;
		}
		/**
		 * Setter for next
		 * @param next The node's next link
		 */
		public void setNext(CourseNode node)
		{
			next = node;
		}

		/**
		 * Getter for name
		 * @return name The node's name
		 */
		public String getName()
		{
			return name;
		}
		/**
		 * Getter for next
		 * @return next The node's next link
		 */
		public CourseNode getNext()
		{
			return next;
		}
	}
}