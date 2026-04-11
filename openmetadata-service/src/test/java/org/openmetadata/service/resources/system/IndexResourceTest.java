package org.openmetadata.service.resources.system;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.openmetadata.service.OpenMetadataApplicationConfig;

class IndexResourceTest {

  @Test
  void testIndexResourceInitialization() {
    // Constructor should not throw even when index.html is not on the classpath
    IndexResource resource = assertDoesNotThrow(IndexResource::new);
    assertNotNull(resource, "IndexResource constructor should succeed");

    // initialize() should not throw
    OpenMetadataApplicationConfig config = new OpenMetadataApplicationConfig();
    config.setBasePath("/test-base-path");
    assertDoesNotThrow(() -> resource.initialize(config));
  }

  @Test
  void testGetIndexFile_returnsNonNull() {
    // getIndexFile should always return a non-null string
    String result = IndexResource.getIndexFile("/static-base");
    assertNotNull(result, "getIndexFile should never return null");
  }
}
