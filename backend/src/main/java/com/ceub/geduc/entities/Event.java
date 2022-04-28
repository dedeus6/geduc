package com.ceub.geduc.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	private String title;
	private String description;
	private Date date;
	private LocalDate startTime;
	private LocalDate endTime;
	
	@ManyToOne
	@JoinColumn(name = "registration")
	private User registration;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "eventsTags",
			joinColumns = @JoinColumn(name = "eventId"),
			inverseJoinColumns = @JoinColumn(name = "tagId")
			)
	private Set<Tag> tags = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usersSubscribe",
			joinColumns = @JoinColumn(name = "eventId"),
			inverseJoinColumns = @JoinColumn(name = "registration")
			)
	private Set<User> users = new HashSet<>();
	
	@Override
	public int hashCode() {
		return Objects.hash(eventId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(eventId, other.eventId);
	}
	

}
