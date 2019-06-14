package tyfanch.electivehelper.bean;

public class OnlineCourse {
    private Integer id;
    private Long productId;
    private Long courseId;
    private String name;
    private String description;
    private String imageUrl;
    private String provider;
    private Double score;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
            "id=" + this.id +
            ", productId=" + this.productId +
            ", courseId=" + this.courseId +
            ", name='" + this.name + '\'' +
            ", description='" + this.description + '\'' +
            ", imageUrl='" + this.imageUrl + '\'' +
            ", provider='" + this.provider + '\'' +
            ", score=" + this.score +
            '}';
    }
}
