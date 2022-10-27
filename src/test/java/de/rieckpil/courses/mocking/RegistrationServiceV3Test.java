package de.rieckpil.courses.mocking;

import de.rieckpil.courses.Address;
import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.RegistrationService;
import de.rieckpil.courses.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceV3Test {

  @Mock
  private UserRepository userRepository;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @InjectMocks
  private RegistrationService cut;

  @Test
  @DisplayName("проверка мока")
  void shouldRegisterUnknownUser() {
    when(bannedUsersClient.isBanned(eq("user"), any(Address.class))).thenReturn(true);

    var banned = bannedUsersClient.isBanned("user", new Address());

    assertTrue(banned);
  }
}
