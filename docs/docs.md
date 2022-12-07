# Docs

## powerpoint from exploration days (extract)

## Questions

### billing 

Dear AWS

Our team had some exploration days recently and I was able to have a play around with Lambda Snapstart for Java Corretto 11.  It's an interesting new service and I hope to make use of it.  However, I have some questions about charging.

The docs all state that there is no extra charge for using it but my experience has been a bit more complicated than that.  It replaces the "init" phase of the lambda's execution with a "restore" phase.  The lambda init phase isn't charged unless it goes over ten seconds (none of our lambdas take anywhere near that time).  However the restore phase on a Snapstart lambda seems to incur a charge... but I can't work out how much.  It's not as straightforward as adding the restore duration to the run duration to get the billing duration.  I set up the same lambda twice in the same account, once with Snapstart and once without, and made them both run once an hour for several days.  I then crunched the REPORT part of the lambda logs to retrieve the stats given.

TODO finish this

### initialisation
Can we use the init phase as a sanity checking phase?

Like the startup time on an old-school server?

what happens if something breaks when it reinitialises?






