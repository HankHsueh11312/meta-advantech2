#ifndef _WESTON_ERROR_H
#define _WESTON_ERROR_H

#if defined(HAVE_ERROR_H)
#include <error.h>
#else
#include <err.h>
#include <string.h>
#define _weston_error(S, E, F, ...) do { \
	if (E) \
		err(S, F ": %s", ##__VA_ARGS__, strerror(E)); \
	else \
		err(S, F, ##__VA_ARGS__); \
} while(0)

#define error _weston_error
#endif

#endif

