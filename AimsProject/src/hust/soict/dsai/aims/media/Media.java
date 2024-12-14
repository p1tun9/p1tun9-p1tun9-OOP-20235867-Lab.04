package hust.soict.dsai.aims.media;


public abstract class Media implements Playable {
	public static int nbMedia = 1;
	private int id = nbMedia++;
	private String title = new String();
	private String category = new String();
	private float cost;
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.setId(id);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	public Media() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public abstract String type();
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Media media = (Media) obj;
	    return this.title.equals(media.title);
	}

}
