package com.project.domain;


import org.apache.commons.lang3.StringUtils;

import java.beans.Transient;
import java.io.Serializable;

/**
 * 商品表 product
 *
 * @author yangbingwen
 * @date 2019-08-01
 */
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 商品id，同时也是商品编号 */
	private Long id;
	/** 商品标题 */
	private String title;
	/** 商品卖点 */
	private String sellpoint;
	/** 商品价格，单位为：分 */
	private Long price;
	/** 库存数量 */
	private Integer num;
	/** 商品图片 */
	private String image;
	/** 所属类目，叶子类目 */
	private Long cid;
	/** 商品状态，1-正常，2-下架，3-删除 */
	private Integer status;

	private String[] images;

	public String[] getImages() {
		if (StringUtils.isNotBlank(this.image)) {
			return StringUtils.split(this.image, ",");
		}
		return null;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
	public void setSellpoint(String sellpoint)
	{
		this.sellpoint = sellpoint;
	}

	public String getSellpoint()
	{
		return sellpoint;
	}
	public void setPrice(Long price)
	{
		this.price = price;
	}

	public Long getPrice()
	{
		return price;
	}
	public void setNum(Integer num)
	{
		this.num = num;
	}

	public Integer getNum()
	{
		return num;
	}
	public void setImage(String image)
	{
		this.image = image;
	}

	public String getImage()
	{
		return image;
	}
	public void setCid(Long cid)
	{
		this.cid = cid;
	}

	public Long getCid()
	{
		return cid;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getStatus()
	{
		return status;
	}

}
