package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUser mockUser;
    TrainController mockController;
    TrainSensor sensor;

    @Before
    public void before() {
        mockUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
        when(mockController.getReferenceSpeed()).thenReturn(200);
    }

    @Test
    public void OverridingSpeedLimitToMoreThanFiveHundred_CallsSetAlarmStateWithTrueOnce() {
        sensor.overrideSpeedLimit(2000);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverridingSpeedLimitToMinus_CallsSetAlarmStateWithTrueOnce() {
        sensor.overrideSpeedLimit(-1);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverridingSpeedLimitToLessThanHalf_CallsSetAlarmStateWithTrueOnce() {
        sensor.overrideSpeedLimit(1);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverridingSpeedLimitToANormalValue_DoesNotCallSetAlarmStateTrue() {
        sensor.overrideSpeedLimit(250);

        verify(mockUser, times(0)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }
}
