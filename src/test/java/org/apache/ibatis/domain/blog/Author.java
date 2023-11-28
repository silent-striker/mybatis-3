/*
 *    Copyright 2009-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.domain.blog;

import java.io.Serializable;

public class Author implements Serializable {

  private static final long serialVersionUID = 1L;
  protected int id;
  protected String username;
  protected String password;
  protected String email;
  protected String bio;
  protected Section favouriteSection;

  public Author() {
    this(-1, null, null, null, null, null);
  }

  public Author(Integer id, String username, String password, String email, String bio, Section section) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.bio = bio;
    this.favouriteSection = section;
  }

  public Author(int id) {
    this(id, null, null, null, null, null);
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public void setFavouriteSection(Section favouriteSection) {
    this.favouriteSection = favouriteSection;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getBio() {
    return bio;
  }

  public Section getFavouriteSection() {
    return favouriteSection;
  }

  private boolean haveSameIdAndBio(Author secondAuthor){
    return (id != secondAuthor.id) || (bio != null ? !bio.equals(secondAuthor.bio) : secondAuthor.bio != null);
  }

  private boolean haveSameEmails(Author secondAuthor){
    return email != null ? !email.equals(secondAuthor.email) : secondAuthor.email != null;
  }

  private boolean haveSamePassword(Author secondAuthor){
    return (password != null ? !password.equals(secondAuthor.password) : secondAuthor.password != null);
  }

  private boolean haveSameUserName(Author secondAuthor){
    return username != null ? !username.equals(secondAuthor.username) : secondAuthor.username != null;
  }

  private boolean haveSameFavouriteSection(Author secondAuthor){
    return favouriteSection != null ? !favouriteSection.equals(secondAuthor.favouriteSection)
      : secondAuthor.favouriteSection != null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Author)) {
      return false;
    }

    Author author = (Author) o;

    if (haveSameIdAndBio(author)
        || haveSameEmails(author)
        || haveSamePassword(author)) {
      return false;
    }
    if (haveSameUserName(author)) {
      return false;
    }
    if (haveSameFavouriteSection(author)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    result = id;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (bio != null ? bio.hashCode() : 0);
    return 31 * result + (favouriteSection != null ? favouriteSection.hashCode() : 0);
  }

  @Override
  public String toString() {
    return "Author : " + id + " : " + username + " : " + email;
  }
}
