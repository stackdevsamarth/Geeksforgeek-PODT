//5-FEB //Intersection Point in Y Shaped Linked Lists

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
          int n = 0;  int m=0;
         for(Node curr=head1; curr.next!=null ; curr=curr.next)
         n++;
          for(Node curr=head2; curr.next!=null ; curr=curr.next)
          m++;
          //s2
          int d = (n>m) ? n-m : m-n;
          
          //traverse d tims in my larger lll
          Node temp = (n>m) ? head1 : head2;
          while(d>0 && temp.next!=null)
          {
              d--; temp=temp.next;
          }
        //   temp  -same level node in larger list
          Node y = (n>m) ? head2 : head1; // smaller ll head
          
          //s3
          while(temp!=null && y!=null)
          {
              if(temp==y) return temp.data;
              temp=temp.next; y=y.next;
          }
          return -1;
	}
}
