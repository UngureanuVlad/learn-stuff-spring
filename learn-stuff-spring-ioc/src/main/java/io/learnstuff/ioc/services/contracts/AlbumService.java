package io.learnstuff.ioc.services.contracts;

import io.learnstuff.ioc.domain.Album;

public interface AlbumService {

  /**
   * <p>
   * Read an album from an outside source.
   * </p>
   * 
   * @return
   */
  public Album readAlbum();
}
