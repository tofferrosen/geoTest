/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.phonegap.hello_world;

public final class R {
    public static final class attr {
    }
    public static final class drawable {
        public static final int ic_launcher=0x7f020000;
        public static final int icon=0x7f020001;
    }
    public static final class integer {
        public static final int endRaceNotifAtPercent=0x7f050009;
        /**  Maximum number of locations to send to the server in one request. 
         */
        public static final int locationDeliveryBatchSize=0x7f050004;
        /**  Time between delivering locations to the server. 
         */
        public static final int locationDeliveryDelayMs=0x7f050003;
        /**  Time between requesting locations. 
         */
        public static final int locationRequestDelayMs=0x7f050002;
        /**  The part of the multiplier that can come from the battery usage adjustment. 
         */
        public static final int maxBatteryTimingMultiplier100=0x7f05000e;
        /**  Battery/Timing Controller Values 
 Our target battery usage per hour. 
         */
        public static final int maxBatteryUsePerHourPct=0x7f05000c;
        /**  The maximum multiplier for "locationRequestDelayMs" 
         */
        public static final int maxGlobalTimingMultiplier100=0x7f05000d;
        public static final int maxNumOfGPSRequests=0x7f050007;
        public static final int maxWaitSendLocsToDCSMs=0x7f05000b;
        public static final int minAccuracyMeters=0x7f050008;
        /**  The rate of backoff incase high battery usage is temporary. 0 for full. 1 means no backoff. 
         */
        public static final int minBatteryTimingMultiplier100=0x7f05000f;
        /**  The minimum number of milliseconds to show the splash screen for. 
         */
        public static final int minSplashScreenDelayMs=0x7f050000;
        public static final int passiveLocDelayMs=0x7f050005;
        public static final int passiveLocDistanceM=0x7f050006;
        /**  How long before tour start to show the "start tracking" button. 
         */
        public static final int startTrackingEarlyMs=0x7f050001;
        public static final int tourReminderNotifDelayMs=0x7f05000a;
    }
    public static final class layout {
        public static final int main=0x7f030000;
    }
    public static final class string {
        public static final int app_name=0x7f06001d;
        public static final int battery_notification_message=0x7f060018;
        /**  Shown if tracking is stopped because it reached minimum battery level. 
         */
        public static final int battery_notification_title=0x7f060017;
        public static final int change_time=0x7f060047;
        /**  New Tour Configuration 
         */
        public static final int confirm_new_register=0x7f06002c;
        public static final int confirm_new_register_overwrite=0x7f06002d;
        public static final int confirm_unregister=0x7f06004a;
        /**  Google Cloud Messaging Sender ID (from Developer API Console) 
         */
        public static final int defaultConfigGcmSenderId=0x7f060006;
        /**  All values are strings in order to be able to store times in ms. 
 A unique persistent ID for the tour. These should not be reused across tours. 
         */
        public static final int defaultConfigRaceId=0x7f060000;
        /**  Maximum time from the start time to track users. (ms) 
         */
        public static final int defaultConfigRaceMaxTime=0x7f060008;
        /**  The name of the tour. 
         */
        public static final int defaultConfigRaceName=0x7f060001;
        /**  Tour Start Time (ms since epoch) 
         */
        public static final int defaultConfigRaceStartTime=0x7f060007;
        /**  DCS base installation path without trailing slash. 
         */
        public static final int defaultConfigServerUrl=0x7f060005;
        /**  Logo to show while tracking. 
         */
        public static final int defaultConfigTourLogo=0x7f060004;
        /**  Official Organizer/Sponsor of the tour. 
         */
        public static final int defaultConfigTourOwner=0x7f060002;
        /**  Url to open if they click the tour logo. 
         */
        public static final int defaultConfigTourUrl=0x7f060003;
        /**  Main Activity 
         */
        public static final int enable_location_provider=0x7f060020;
        public static final int finish_time_before_start_time=0x7f06003d;
        public static final int finish_time_too_late=0x7f06003b;
        public static final int intro_text=0x7f060034;
        public static final int location_settings=0x7f060021;
        public static final int low_batt_percent_dialog_title=0x7f060050;
        public static final int low_batt_percent_summary=0x7f06004f;
        public static final int low_batt_percent_title=0x7f06004e;
        /**  Change Time 
         */
        public static final int menu_changetime=0x7f060046;
        public static final int menu_messages=0x7f060052;
        public static final int menu_settings=0x7f06004d;
        public static final int menu_unregister=0x7f060049;
        /**  Messages 
         */
        public static final int messages=0x7f060051;
        public static final int next=0x7f060033;
        /**  Post-Tracking 
         */
        public static final int no_active_race=0x7f060028;
        public static final int no_location_notification_message=0x7f06000d;
        /**  Shown if the user does not have either the GPS or network location services enabled. 
         */
        public static final int no_location_notification_title=0x7f06000c;
        public static final int no_messages_received=0x7f060053;
        public static final int no_network_access=0x7f060044;
        public static final int no_network_notification_message=0x7f060016;
        /**  Shown when tracking is in progress but there is no data connection. 
         */
        public static final int no_network_notification_title=0x7f060015;
        public static final int notification_tour_cancelled_message=0x7f06001c;
        /**  Shown when tour has been cancelled 
         */
        public static final int notification_tour_cancelled_title=0x7f06001b;
        public static final int notification_updated_times_message=0x7f06000b;
        /**  Shown when the race times have changed and user needs to set their start time. 
         */
        public static final int notification_updated_times_title=0x7f06000a;
        public static final int pick_tracking=0x7f060035;
        public static final int previous=0x7f060032;
        /**  Title for custom messages from the server. 
         */
        public static final int push_message_title=0x7f060009;
        public static final int race_finish_reminder_message=0x7f06001a;
        /**  Shown partway through the tour (configurable in config.xml). 
         */
        public static final int race_finish_reminder_title=0x7f060019;
        public static final int race_ongoing_notification_message=0x7f060014;
        /**  Shown when the race is occuring but the user has not started tracking yet. 
         */
        public static final int race_ongoing_notification_title=0x7f060013;
        public static final int race_reminder_notification__gps_message=0x7f06000f;
        public static final int race_reminder_notification_message=0x7f060010;
        /**  Shown a predetermined amount of time before the start of the tour. 
         */
        public static final int race_reminder_notification_title=0x7f06000e;
        public static final int race_tracking_notification_message=0x7f060012;
        /**  Shown when the user is being tracked. 
         */
        public static final int race_tracking_notification_title=0x7f060011;
        public static final int register=0x7f060030;
        public static final int registerforNewTour=0x7f060055;
        /**  Registration 
         */
        public static final int registration=0x7f06002f;
        public static final int registration_failed=0x7f060045;
        public static final int restart_tracking=0x7f060026;
        public static final int save=0x7f060031;
        /**  Settings 
         */
        public static final int settings=0x7f06004c;
        public static final int sponsor_name=0x7f06001f;
        /**  Sponsor Info 
         */
        public static final int sponsored_by=0x7f06001e;
        public static final int start_time_after_race_finish=0x7f06003c;
        public static final int start_time_description=0x7f060039;
        public static final int start_time_in_past=0x7f06003e;
        public static final int start_time_title=0x7f060038;
        public static final int start_time_too_early=0x7f06003a;
        public static final int start_tracking=0x7f060023;
        public static final int stop_tracking=0x7f060027;
        public static final int thankyou_participation=0x7f06002a;
        public static final int toggle_automatic_off=0x7f060037;
        public static final int toggle_automatic_on=0x7f060036;
        public static final int total_time_track_label=0x7f06002b;
        public static final int tour_cancelled=0x7f060029;
        public static final int tour_fetch_failed=0x7f06002e;
        public static final int tour_started=0x7f060024;
        public static final int tour_times_changed_main=0x7f060054;
        public static final int tracking_agree=0x7f06003f;
        public static final int tracking_agreement_automatic=0x7f060040;
        public static final int tracking_agreement_manual=0x7f060041;
        public static final int tracking_agreement_not_checked=0x7f060043;
        public static final int tracking_agreement_title=0x7f060042;
        /**  Countdown 
         */
        public static final int tracking_for_label=0x7f060022;
        /**  Tracking 
         */
        public static final int tracking_in_progress=0x7f060025;
        /**  Unregister 
         */
        public static final int unregister=0x7f060048;
        public static final int unregistered_rider=0x7f06004b;
    }
    public static final class xml {
        public static final int config=0x7f040000;
        public static final int settings=0x7f040001;
    }
}
